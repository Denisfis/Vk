package com.example.vk.domain.applist

class GetAppListUseCase(
    private val repository: AppListRepository,
) {
    suspend operator fun invoke(): List<AppSummary> = repository.getApps()
}
