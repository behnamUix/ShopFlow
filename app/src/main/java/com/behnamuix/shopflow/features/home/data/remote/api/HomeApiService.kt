package com.behnamuix.shopflow.features.home.data.remote.api

import com.behnamuix.shopflow.features.home.data.remote.dto.ProductResponseDto
import retrofit2.http.GET

interface HomeApiService {
    @GET("products?limit=10")
    suspend fun getProducts(): ProductResponseDto
}
