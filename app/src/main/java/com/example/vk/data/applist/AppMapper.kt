package com.example.vk.data.applist

import com.example.vk.domain.applist.AppSummary
import com.example.vk.domain.applist.Category

class AppMapper {

    fun toDomain(dto: AppDto): AppSummary = AppSummary(
        id = dto.id,
        name = dto.name,
        description = dto.description,
        category = toCategory(dto.category),
        iconUrl = dto.iconUrl,
    )

    // Неизвестная категория из сети не должна ломать экран
    private fun toCategory(value: String): Category =
        Category.entries.firstOrNull { it.name == value } ?: Category.APP
}
