package com.example.dressshop.data.remote.dto

import com.example.dressshop.data.local.DressEntity
import com.example.dressshop.domain.model.Dress

//data class DressDto(
//    val dressDto: List<DressDtoItem?>? = null
//)

data class DressDtoItem(
    val seller: Boolean? = null,
    val typeOfProduct: String? = null,
    val color: String? = null,
    val city: String? = null,
    val wordsToSearch: String? = null,
    val latitude: Any? = null,
    val description: String? = null,
    val title: String? = null,
    val manufacturer: String? = null,
    val productCondition: Boolean? = null,
    val urls: List<String?>? = null,
    val price: Int? = null,
    val model: String? = null,
    val id: Int? = null,
    val longitude: Any? = null,
    val height: String? = null,
    val productIsNew: Boolean? = null,
    val sex: String? = null,
    val userId: String? = null,
    val url: String? = null,
    val article: String? = null,
    val manufacturerCountry: String? = null,
    val typeOfCollection: String? = null,
    val innerId: String? = null,
    val createdDate: Any? = null,
    val size: String? = null,
    val sleeve: String? = null,
    val fabric: String? = null,
    val silhouette: String? = null,
    val category: String? = null
) {
    fun toDress() = Dress(
        id = id,
        manufacturer = manufacturer ?: "",
        model = model ?: "",
        silhouette = silhouette ?: "",
        sex = sex ?: "",
        fabric = fabric ?: "",
        sleeve = sleeve ?: "",
        city = city ?: "",
        size = size ?: "",
        color = color ?: "",
        url = url ?: "no image"
    )

    fun toDressEntity() = DressEntity(
        id = id ?: 0,
        manufacturer = manufacturer ?: "",
        model = model ?: "",
        silhouette = silhouette ?: "",
        sex = sex ?: "",
        fabric = fabric ?: "",
        sleeve = sleeve ?: "",
        city = city ?: "",
        size = size ?: "",
        color = color ?: "",
        url = url ?: "",
    )
}

