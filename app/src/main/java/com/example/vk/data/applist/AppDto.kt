package com.example.vk.data.applist

/** Приложение в том виде, в котором оно приходит из сети. */
data class AppDto(
    val id: String,
    val name: String,
    val description: String,
    val category: String,
    val iconUrl: String,
)
