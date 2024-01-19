package com.example.myapartments.domain

import androidx.room.Dao
import androidx.room.Insert
import com.example.myapartments.data.LoginDto

@Dao
interface LoginDao {
    @Insert
    suspend fun addLoginDto(loginDto: LoginDto)
}