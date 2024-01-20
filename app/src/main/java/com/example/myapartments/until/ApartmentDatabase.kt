package com.example.myapartments.until

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapartments.data.dto.ApartmentDto
import com.example.myapartments.data.dto.DuesDto
import com.example.myapartments.data.dto.DuesFlatDto
import com.example.myapartments.data.dto.LoginDto
import com.example.myapartments.data.dto.UserDto
import com.example.myapartments.domain.dao.LoginDao

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
abstract class ApartmentDatabase : RoomDatabase() {

    //abstract fun userDao(): UserDao
    abstract fun loginDao(): LoginDao

}