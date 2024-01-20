package com.example.myapartments.domain.use_case

import com.example.myapartments.data.dto.LoginDto
import com.example.myapartments.data.repository.LoginRepositoryImp
import com.example.myapartments.domain.model.Login
import com.example.myapartments.until.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase
@Inject constructor(
    private val loginRepository: LoginRepositoryImp
) {
    fun addLogin(login: Login) = flow<Resource<Boolean>> {
        val loginDto = LoginDto(login.nickName, login.password)
        loginRepository.addLogin(loginDto)
        emit(Resource.Success(true))
    }.catch { emit(Resource.Error(it.localizedMessage)) }

    fun getLogin(login: Login) = flow<Resource<Boolean>> {
        val loginDto = LoginDto(login.nickName, login.password)
        emit(Resource.Success(loginRepository.getLogin(loginDto) != null))
    }.catch { emit(Resource.Error(it.localizedMessage)) }

}