package com.example.vk.data.appdetails

import com.example.vk.data.network.CatalogApi
import com.example.vk.domain.appdetails.AppDetails
import com.example.vk.domain.appdetails.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val api: CatalogApi,
    private val mapper: AppDetailsMapper,
) : AppDetailsRepository {

    override suspend fun getAppDetails(id: String): AppDetails =
        mapper.toDomain(api.getAppDetails(id))
}
