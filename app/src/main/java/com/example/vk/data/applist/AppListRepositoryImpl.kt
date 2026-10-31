package com.example.vk.data.applist

import com.example.vk.domain.applist.AppListRepository
import com.example.vk.domain.applist.AppSummary

class AppListRepositoryImpl(
    private val api: AppListApi,
    private val mapper: AppMapper,
) : AppListRepository {

    override suspend fun getApps(): List<AppSummary> =
        api.getApps().map(mapper::toDomain)
}
