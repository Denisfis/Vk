package com.example.vk.data.appdetails

import com.example.vk.data.applist.toCategory
import com.example.vk.domain.appdetails.AppDetails
import javax.inject.Inject

class AppDetailsMapper @Inject constructor() {

    fun toDomain(dto: AppDetailsDto): AppDetails = AppDetails(
        id = dto.id,
        name = dto.name,
        developer = dto.developer,
        category = dto.category.toCategory(),
        ageRating = dto.ageRating,
        sizeMb = dto.size.toFloat(),
        iconUrl = dto.iconUrl,
        screenshotUrls = dto.screenshots.orEmpty(),
        description = dto.description,
    )
}
