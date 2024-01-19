package com.example.myapartments.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDto(
    var name:String,
    var sourName:String,
    var apartmentId:Int,
    var flat:String,
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}