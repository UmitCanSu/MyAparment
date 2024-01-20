package com.example.myapartments.presentation.login

import com.example.myapartments.domain.model.Login


sealed class LoginFragmentOnEvent {
    data class Login(var login: com.example.myapartments.domain.model.Login) : LoginFragmentOnEvent()
}
