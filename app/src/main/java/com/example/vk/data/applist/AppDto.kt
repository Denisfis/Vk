package com.example.vk.data.applist

import kotlinx.serialization.Serializable

/** Элемент каталога в том виде, в котором он приходит с сервера. */
@Serializable
data class AppDto(
    val id: String,
    val name: String,
    val description: String = "",
    val category: String = "",
    val iconUrl: String = "",
)
