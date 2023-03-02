package com.example.dressshop.di

import android.content.Context
import androidx.room.Room
import com.example.dressshop.data.local.AppDatabase
import com.example.dressshop.data.local.dao.DressDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideDressDao(appDatabase: AppDatabase): DressDao = appDatabase.dressDao()

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase =
        Room.databaseBuilder(appContext, AppDatabase::class.java, "Dress base").build()

}
