package com.example.myapartments.presentation.login

sealed class LoginFragmentState {
    object Idle : LoginFragmentState()
    object Loading : LoginFragmentState()
    object CorrectPassword : LoginFragmentState()
    object WrongPassword : LoginFragmentState()
    data class Error(var message: String) : LoginFragmentState()
}