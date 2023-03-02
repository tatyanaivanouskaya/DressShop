package com.example.dressshop.data.remote.repository

import com.example.dressshop.data.remote.dto.DressDto
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitApiService {

    @GET
    fun getDressesList(): Response<DressDto>

    @GET
    fun getDressInfo(id: Int)

    companion object {
        const val BASE_URL = "http://q11.jvmhost.net/dress_json/"
    }
}