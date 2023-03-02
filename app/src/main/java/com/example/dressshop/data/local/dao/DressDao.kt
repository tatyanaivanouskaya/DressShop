package com.example.dressshop.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dressshop.data.local.DressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DressDao {
    @Query("SELECT * FROM dresses")
    fun getAllDresses(): Flow<List<DressEntity>>

    @Query("SELECT * FROM dresses WHERE id = :dressId")
    fun getDressById(dressId: Int): DressEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllDresses(list: List<DressEntity>)
}