package com.example.myapartments.data.repository

import com.example.myapartments.data.dto.LoginDto
import com.example.myapartments.domain.dao.LoginDao
import com.example.myapartments.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImp
@Inject constructor(
    private val loginDao: LoginDao
) : LoginRepository {
    override suspend fun addLogin(login: LoginDto) =
        loginDao.addLoginDto(login)


    override suspend fun updateLogin(login: LoginDto) =
        loginDao.updateLoginDto(login)


    override suspend fun getLogin(login: LoginDto): LoginDto =
        loginDao.getUser(login.nickName, login.password)

}