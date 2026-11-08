package com.example.vk.di

import com.example.vk.data.applist.AppListApi
import com.example.vk.data.applist.AppListRepositoryImpl
import com.example.vk.domain.applist.AppListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    // Кто запрашивает интерфейс AppListRepository, получает AppListRepositoryImpl
    @Binds
    @Singleton
    fun bindAppListRepository(impl: AppListRepositoryImpl): AppListRepository

    companion object {

        @Provides
        @Singleton
        fun provideAppListApi(): AppListApi = AppListApi()
    }
}
