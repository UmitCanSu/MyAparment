package com.example.myapartments.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapartments.data.dto.LoginDto

@Dao
interface LoginDao {
    @Insert
    suspend fun addLoginDto(loginDto: LoginDto)

    @Insert
    suspend fun updateLoginDto(loginDto: LoginDto)

    @Query("Select * from LoginDto where nickName =:nickName and password =:password")
    suspend fun getUser(nickName: String, password: String): LoginDto
}