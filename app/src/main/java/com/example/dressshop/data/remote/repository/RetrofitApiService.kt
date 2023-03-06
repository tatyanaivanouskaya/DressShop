package com.example.dressshop.data.remote.repository

import com.example.dressshop.data.remote.dto.DressDtoItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitApiService {

    @GET("/dress_json")
    suspend fun getDressesList(): Response<List<DressDtoItem>>


    @POST("/dress")
    suspend fun saveDress(@Body dressRequestModel: DressRequestModel): Response<DressRequestModel>

    companion object {
        const val BASE_URL = "http://q11.jvmhost.net/"
    }
}