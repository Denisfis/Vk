package com.example.vk.data.applist

import com.example.vk.data.network.CatalogApi
import com.example.vk.domain.applist.AppListRepository
import com.example.vk.domain.applist.AppSummary
import javax.inject.Inject

class AppListRepositoryImpl @Inject constructor(
    private val api: CatalogApi,
    private val mapper: AppMapper,
) : AppListRepository {

    override suspend fun getApps(): List<AppSummary> =
        api.getCatalog().map(mapper::toDomain)
}
