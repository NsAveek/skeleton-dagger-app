package com.example.skeletondaggerapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.skeletondaggerapp.db.dao.DemoDAO


@Database(entities=[DemoRoomObjectModel::class], version=1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun demoDao(): DemoDAO
}