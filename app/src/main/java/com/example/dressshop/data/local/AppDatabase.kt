package com.example.dressshop.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dressshop.data.local.dao.DressDao

@Database(entities = [DressEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun dressDao(): DressDao
}