package com.example.dressshop.di

import com.example.dressshop.data.local.dao.DressDao
import com.example.dressshop.data.remote.repository.RetrofitApiService
import com.example.dressshop.domain.repository.DressRepository
import com.example.dressshop.domain.repository.DressRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DressRepositoryModule {

    @Singleton
    @Provides
    fun provideDressRepository(
        retrofitService: RetrofitApiService,
        dressDao: DressDao
    ): DressRepository = DressRepositoryImpl(service = retrofitService, dressDao = dressDao)

}