package com.example.myapartments.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DuesDto(
    var apartmentId: Int,
    var price: Float,
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
