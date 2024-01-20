package com.example.myapartments.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ApartmentDto(
    var address: String,
    var apartmentNo: String
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}