package com.behnamuix.shopflow.features.home.domain.repository

import com.behnamuix.shopflow.features.home.domain.model.CategoryModel
import com.behnamuix.shopflow.features.home.domain.model.PhoneModel
import com.behnamuix.shopflow.features.home.domain.model.ProductModel

interface HomeRepository {
    suspend fun getProduct(): List<ProductModel>

    suspend fun getCategories(): List<CategoryModel>

    suspend fun getPhones(): List<PhoneModel>
}