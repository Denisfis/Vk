package com.example.vk.domain.appdetails

import com.example.vk.domain.applist.Category

data class AppDetails(
    val id: String,
    val name: String,
    val developer: String,
    val category: Category,
    val ageRating: Int,
    val sizeMb: Float,
    val iconUrl: String,
    val screenshotUrls: List<String>,
    val description: String,
)
