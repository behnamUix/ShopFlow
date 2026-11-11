package com.behnamuix.shopflow.features.home.presentation

import com.behnamuix.shopflow.features.home.domain.model.ProductModel

object HomeContract {
    data class HomeState(
        val products: List<ProductModel> = emptyList(),
        val isLoading: Boolean = false,
        val errorMessage: String? = null,
    )

    sealed interface HomeAction {
        data object GetProducts : HomeAction
    }
}
