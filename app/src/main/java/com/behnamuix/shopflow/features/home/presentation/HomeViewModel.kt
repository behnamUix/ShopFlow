package com.behnamuix.shopflow.features.home.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.behnamuix.shopflow.features.home.domain.usecase.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productUseCase: ProductsUseCase,
) : ViewModel() {
    private val _homeState = MutableStateFlow(HomeContract.HomeState())
    val homeState: StateFlow<HomeContract.HomeState> = _homeState.asStateFlow()

    fun onAction(action: HomeContract.HomeAction) {
        when (action) {
            is HomeContract.HomeAction.GetProducts -> getProducts()
        }
    }

    private fun getProducts() {
        viewModelScope.launch {
            _homeState.value = _homeState.value.copy(isLoading = true, errorMessage = null)
            try {
                val products = productUseCase.getProducts()
                _homeState.value = _homeState.value.copy(
                    products = products,
                    isLoading = false,
                )
            } catch (e: Exception) {
                Log.d("PRODUCTS",_homeState.value.products.size.toString())
                e.printStackTrace()
                _homeState.value = _homeState.value.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "خطا در برقراری ارتباط با سرور",
                )
            }
        }
    }
}
