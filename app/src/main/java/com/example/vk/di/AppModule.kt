package com.example.vk.di

import com.example.vk.data.applist.AppListApi
import com.example.vk.data.applist.AppListRepositoryImpl
import com.example.vk.data.applist.AppMapper
import com.example.vk.domain.applist.AppListRepository
import com.example.vk.domain.applist.GetAppListUseCase

/** Ручное внедрение зависимостей: единственное место, где слои связываются друг с другом. */
object AppModule {

    private val appListRepository: AppListRepository by lazy {
        AppListRepositoryImpl(api = AppListApi(), mapper = AppMapper())
    }

    fun provideGetAppListUseCase(): GetAppListUseCase = GetAppListUseCase(appListRepository)
}
