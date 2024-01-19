package com.example.myapartments.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.example.myapartments.data.UserDto

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(userDao: UserDto)

    @Update
    suspend fun updateUser(userDao: UserDto)
}