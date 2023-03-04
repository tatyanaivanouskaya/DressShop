package com.example.dressshop.domain.model

import com.example.dressshop.data.remote.dto.DressDtoItem


data class Dress(
    val id: Int? = null,
    var manufacturer: String = "",
    var model: String = "",
    var silhouette: String = "",
    var sex: String = "",
    var fabric: String = "",
    var sleeve: String = "",
    var city: String = "",
    var size: String = "",
    var color: String = "",
    var url: String = "",
    var category: String = ""
) {
    fun toDressDto() = DressDtoItem(
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