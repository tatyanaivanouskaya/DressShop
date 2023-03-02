package com.example.dressshop.di

import com.example.dressshop.data.remote.repository.RetrofitApiService
import com.example.dressshop.data.remote.repository.RetrofitApiService.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    var httpClient = OkHttpClient.Builder().apply {
        addInterceptor(logging)
    }


    @Singleton
    @Provides
    fun provideRetrofitService(): RetrofitApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(httpClient.build())
        .build()
        .create(RetrofitApiService::class.java)

}