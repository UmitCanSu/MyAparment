package com.example.myapartments.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapartments.domain.model.Login
import com.example.myapartments.domain.use_case.LoginUseCase
import com.example.myapartments.until.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject constructor(
    private val loginUseCase: LoginUseCase,
) : ViewModel() {
    private val _state: MutableStateFlow<LoginFragmentState> =
        MutableStateFlow(LoginFragmentState.Idle)
    val state: SharedFlow<LoginFragmentState> = _state

    private suspend fun login(login: Login) {
        loginUseCase.getLogin(login)
            .onStart { _state.value = LoginFragmentState.Loading }
            .collect {
                when (it) {
                    is Resource.Error -> _state.value = LoginFragmentState.Error(it.message!!)
                    is Resource.Success -> _state.value =
                        if (it.data!!) LoginFragmentState.CorrectPassword
                        else LoginFragmentState.WrongPassword
                }
            }
    }

    private suspend fun addUser() {
        val login = Login("umit", "1")
        loginUseCase.addLogin(login)
            .onStart { _state.value = LoginFragmentState.Loading }
            .collect {

            }
    }

    fun onEvent(onEvent: LoginFragmentOnEvent) {
        when (onEvent) {
            is LoginFragmentOnEvent.Login -> {
                viewModelScope.launch { login(onEvent.login) }
            }
        }
    }
}