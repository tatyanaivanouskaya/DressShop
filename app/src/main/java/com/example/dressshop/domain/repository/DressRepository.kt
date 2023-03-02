package com.example.dressshop.domain.repository

import com.example.dressshop.data.local.DressEntity
import com.example.dressshop.data.remote.dto.DressDto
import com.example.dressshop.domain.model.Dress
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface DressRepository {

    fun getDressesList():Response<DressDto>

    fun loadDressesIntoDB(list: List<DressEntity>)

    fun getDressesFromDB(): Flow<List<DressEntity>>

    fun getDressInfo(id: Int): Dress

    fun saveDress(dress: Dress)
}