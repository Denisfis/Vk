package com.example.vk.domain.applist

interface AppListRepository {
    suspend fun getApps(): List<AppSummary>
}
