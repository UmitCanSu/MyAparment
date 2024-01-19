package com.example.myapartments.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoginDto(
    var nickName:String,
    var password:String,
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
