package com.example.myapartments.di

import android.content.Context
import androidx.room.Room
import com.example.myapartments.until.ApartmentDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityComponent::class)
object Module {

    @Provides
    fun provideApartmentDb(@ApplicationContext applicationContext: Context): ApartmentDatabase {
        return Room.databaseBuilder(
            applicationContext,
            ApartmentDatabase::class.java,
            "apartmen"
        ).build()
    }
}