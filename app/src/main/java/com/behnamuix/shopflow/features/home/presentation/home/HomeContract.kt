package com.behnamuix.shopflow.features.home.presentation.home

import com.behnamuix.shopflow.features.home.domain.model.CategoryModel
import com.behnamuix.shopflow.features.home.domain.model.ProductModel

object HomeContract {
    data class HomeState(
        val products: List<ProductModel> = emptyList(),
        val isLoading: Boolean = false,
        val errorMessage: String? = null,
        val categories:List<CategoryModel> = emptyList()
    )

    sealed interface HomeAction {
        data object GetProducts : HomeAction
        data object GetCategories: HomeAction
    }
}
