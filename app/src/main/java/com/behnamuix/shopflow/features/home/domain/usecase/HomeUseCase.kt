package com.behnamuix.shopflow.features.home.domain.usecase

import com.behnamuix.shopflow.features.home.domain.model.ProductModel
import com.behnamuix.shopflow.features.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val repository: HomeRepository
) {
    suspend fun getProducts(): List<ProductModel> {
        return repository.getProduct()
    }

}