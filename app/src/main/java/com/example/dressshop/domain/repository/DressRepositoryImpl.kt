package com.example.dressshop.domain.repository

import com.example.dressshop.data.local.DressEntity
import com.example.dressshop.data.local.dao.DressDao
import com.example.dressshop.data.remote.dto.DressDtoItem
import com.example.dressshop.data.remote.repository.RetrofitApiService
import com.example.dressshop.domain.model.Dress
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject


class DressRepositoryImpl @Inject constructor (
   val service: RetrofitApiService,
   val dressDao: DressDao
): DressRepository {

    override suspend fun getDressesList(): Response<List<DressDtoItem>> = service.getDressesList()

    override suspend fun loadDressesIntoDB(list: List<DressEntity>) = dressDao.saveAllDresses(list)

    override fun getDressesFromDB(): Flow<List<DressEntity>> = dressDao.getAllDresses()


    override fun getDressInfo(id: Int): Dress {
        TODO("Not yet implemented")
    }

    override fun saveDress(dress: Dress) {
        TODO("Not yet implemented")
    }
}