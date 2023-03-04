package com.example.dressshop.data.remote.repository

import com.example.dressshop.data.remote.dto.DressDtoItem
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitApiService {

    @GET("/dress_json")
    suspend fun getDressesList(): Response<List<DressDtoItem>>

   // @GET
    //fun getDressInfo(id: Int)

    companion object {
        const val BASE_URL = "http://q11.jvmhost.net/"
    }
}