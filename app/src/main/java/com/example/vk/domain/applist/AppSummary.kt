package com.example.vk.domain.applist

/** Краткая информация о приложении для отображения в списке. */
data class AppSummary(
    val id: String,
    val name: String,
    val description: String,
    val category: Category,
    val iconUrl: String,
)
