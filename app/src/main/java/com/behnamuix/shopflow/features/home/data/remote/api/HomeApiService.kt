package com.behnamuix.shopflow.features.home.data.remote.api

import com.behnamuix.shopflow.features.home.data.remote.dto.category.CategoryResponseDto
import com.behnamuix.shopflow.features.home.data.remote.dto.home.ProductResponseDto

import retrofit2.http.GET

interface HomeApiService {
    @GET("products?limit=10")
    suspend fun getProducts(): ProductResponseDto

    @GET("products/categories")
    suspend fun getCategories(): CategoryResponseDto

    @GET("products/search?q=phone")
    suspend fun getPhone(): ProductResponseDto
}
