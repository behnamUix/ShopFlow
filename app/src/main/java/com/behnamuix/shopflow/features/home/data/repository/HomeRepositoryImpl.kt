package com.behnamuix.shopflow.features.home.data.repository

import android.util.Log
import com.behnamuix.shopflow.features.home.data.remote.api.HomeApiService
import com.behnamuix.shopflow.features.home.data.remote.dto.category.toDomain
import com.behnamuix.shopflow.features.home.data.remote.dto.home.toDomain
import com.behnamuix.shopflow.features.home.domain.model.CategoryModel
import com.behnamuix.shopflow.features.home.domain.model.ProductModel
import com.behnamuix.shopflow.features.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApiService: HomeApiService,
) : HomeRepository {
    override suspend fun getProduct(): List<ProductModel> {
        val response = homeApiService.getProducts()
        Log.d("PRODUCTS",response.products.size.toString())
        return response.products.map { it.toDomain() }
    }

    override suspend fun getCategories(): List<CategoryModel> {
        val response=homeApiService.getCategories()
        return response.categories.map {
            it.toDomain()
        }
    }
}
