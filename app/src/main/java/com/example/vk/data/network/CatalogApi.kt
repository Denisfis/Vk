package com.example.vk.data.network

import com.example.vk.data.appdetails.AppDetailsDto
import com.example.vk.data.applist.AppDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CatalogApi {

    /** GET http://185.103.109.134/catalog */
    @GET("catalog")
    suspend fun getCatalog(): List<AppDto>

    /** GET http://185.103.109.134/{id}, где id берётся из элемента каталога */
    @GET("{id}")
    suspend fun getAppDetails(@Path("id") id: String): AppDetailsDto
}
