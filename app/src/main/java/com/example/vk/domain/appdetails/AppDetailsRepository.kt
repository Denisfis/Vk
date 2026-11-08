package com.example.vk.domain.appdetails

interface AppDetailsRepository {
    suspend fun getAppDetails(id: String): AppDetails
}
