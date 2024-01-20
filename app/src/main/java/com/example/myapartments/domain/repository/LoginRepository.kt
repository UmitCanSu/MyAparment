package com.example.myapartments.domain.repository

import com.example.myapartments.data.dto.LoginDto

interface LoginRepository {
    suspend fun addLogin(login: LoginDto)
    suspend fun updateLogin(login: LoginDto)
    suspend fun getLogin(login: LoginDto):LoginDto
}