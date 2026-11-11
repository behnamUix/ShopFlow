package com.behnamuix.shopflow.features.home.domain.usecase

import com.behnamuix.shopflow.features.home.domain.model.ProductModel
import com.behnamuix.shopflow.features.home.domain.repository.ProductRepository
import javax.inject.Inject

class ProductsUseCase @Inject constructor(
    private val repository: ProductRepository
)  {
    suspend fun getProducts():List<ProductModel>{
        return repository.getProduct()
    }

}