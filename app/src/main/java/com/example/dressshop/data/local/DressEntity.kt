package com.example.dressshop.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dressshop.domain.model.Dress

@Entity(tableName = "dresses")
data class DressEntity(
    @PrimaryKey
    var id: Int,
    var manufacturer: String,
    var model: String,
    var silhouette: String,
    var sex: String,
    var fabric: String,
    var sleeve: String,
    var city: String,
    var size: String,
    var color: String,
    var url: String,
    var category: String
) {
    fun toDress() = Dress(
        id = id,
        manufacturer = manufacturer,
        model = model,
        silhouette = silhouette,
        sex = sex,
        fabric = fabric,
        sleeve = sleeve,
        city = city,
        size = size,
        color = color,
        url = url,
        category = category
    )
}