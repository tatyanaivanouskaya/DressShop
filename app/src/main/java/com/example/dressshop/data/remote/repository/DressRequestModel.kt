package com.example.dressshop.data.remote.repository

import retrofit2.http.Field

data class DressRequestModel(
    @Field("manufacturer") val manufacturer: String,
    @Field("model") val model: String,
    @Field("sex") val sex: String,
    @Field("fabric") val fabric: String,
    @Field("city") val city: String,
    @Field("color") val color: String,
    @Field("url") val url: String
)
