package com.behnamuix.shopflow.features.home.domain.repository

import com.behnamuix.shopflow.features.home.domain.model.ProductModel

interface HomeRepository {
    suspend fun getProduct(): List<ProductModel>
}