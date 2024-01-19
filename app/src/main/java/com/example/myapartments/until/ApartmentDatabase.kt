package com.example.myapartments.until

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapartments.data.ApartmentDto
import com.example.myapartments.data.DuesDto
import com.example.myapartments.data.DuesFlatDto
import com.example.myapartments.data.LoginDto
import com.example.myapartments.data.UserDto
import com.example.myapartments.domain.LoginDao
import com.example.myapartments.domain.UserDao

@Database(
    entities = [
        ApartmentDto::class,
        DuesDto::class,
        DuesFlatDto::class,
        LoginDto::class,
        UserDto::class
    ], version = 1
)
@TypeConverters(Converters::class)
abstract class ApartmentDatabase:RoomDatabase() {

    abstract fun userDao():UserDao
    abstract fun loginDao():LoginDao

}