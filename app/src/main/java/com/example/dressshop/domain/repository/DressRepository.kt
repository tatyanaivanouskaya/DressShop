package com.example.dressshop.domain.repository

import com.example.dressshop.data.local.DressEntity
import com.example.dressshop.data.remote.dto.DressDtoItem
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface DressRepository {

    suspend fun getDressesList():Response<List<DressDtoItem>>

    suspend fun loadDressesIntoDB(list: List<DressEntity>)

    fun getDressesFromDB(): Flow<List<DressEntity>>

    fun getDressInfo(id: Int): Flow<DressEntity>

    //fun saveDress(dress: Dress)
}