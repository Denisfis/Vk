package com.example.vk.data.appdetails

import kotlinx.serialization.Serializable

/** Подробная информация о приложении в том виде, в котором она приходит с сервера. */
@Serializable
data class AppDetailsDto(
    val id: String,
    val name: String,
    val developer: String = "",
    val category: String = "",
    val ageRating: Int = 0,
    val size: Double = 0.0,
    val iconUrl: String = "",
    val screenshots: List<String>? = null,
    val description: String = "",
)
