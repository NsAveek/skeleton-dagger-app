package com.example.skeletondaggerapp.di.scope.application

import android.app.Application
import androidx.room.Room
import com.example.skeletondaggerapp.db.AppDatabase
import com.example.skeletondaggerapp.db.dao.DemoDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(applicationContext : Application) : AppDatabase {
        return Room.databaseBuilder(
            applicationContext,AppDatabase::class.java,"demodatabase.db"
        ).build()
    }
    @Provides
    @Singleton
    fun provideWeatherDao(database: AppDatabase) : DemoDAO {
        return database.demoDao()
    }
}