package com.example.myapartments.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class DuesFlatDto(
    var duesId: Int,
    var paymentDate: Date,
    var userId: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
