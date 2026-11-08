package com.example.vk.data.applist

import com.example.vk.domain.applist.AppSummary
import javax.inject.Inject

class AppMapper @Inject constructor() {

    fun toDomain(dto: AppDto): AppSummary = AppSummary(
        id = dto.id,
        name = dto.name,
        description = dto.description,
        category = dto.category.toCategory(),
        iconUrl = dto.iconUrl,
    )
}
