package com.example.myapartments.data.di

import android.content.Context
import androidx.room.Room
import com.example.myapartments.data.repository.LoginRepositoryImp
import com.example.myapartments.domain.dao.LoginDao
import com.example.myapartments.domain.repository.LoginRepository
import com.example.myapartments.until.ApartmentDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideApartmentDb(@ApplicationContext applicationContext: Context): ApartmentDatabase {
        return Room.databaseBuilder(
            applicationContext,
            ApartmentDatabase::class.java,
            "apartment.db"
        ).build()
    }
    @Provides
    @Singleton
    fun provideLoginRepository(loginDao: LoginDao): LoginRepository {
        return LoginRepositoryImp(loginDao)
    }
    @Provides
    @Singleton
    fun provideLoginDao(database: ApartmentDatabase): LoginDao {
        return database.loginDao()
    }
}