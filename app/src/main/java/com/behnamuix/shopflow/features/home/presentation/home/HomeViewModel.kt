package com.behnamuix.shopflow.features.home.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.behnamuix.shopflow.features.home.domain.usecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productUseCase: HomeUseCase,
) : ViewModel() {
    private val _homeState = MutableStateFlow(HomeContract.HomeState())
    val homeState: StateFlow<HomeContract.HomeState> = _homeState.asStateFlow()

    fun onAction(action: HomeContract.HomeAction) {
        when (action) {
            is HomeContract.HomeAction.GetProducts -> getProducts()
            is HomeContract.HomeAction.GetCategories -> getCategory()
            is HomeContract.HomeAction.GetPhones -> getPhones()
        }
    }
    private fun getPhones(){
        viewModelScope.launch {
            _homeState.value = _homeState.value.copy(isLoading = true, errorMessage = null)
            try {
                val phones = productUseCase.getPhones()
                _homeState.value = _homeState.value.copy(
                    phones = phones,
                    isLoading = false,
                )
            } catch (e: Exception) {

                e.printStackTrace()
                _homeState.value = _homeState.value.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "خطا در برقراری ارتباط با سرور",
                )
            }
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

                e.printStackTrace()
                _homeState.value = _homeState.value.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "خطا در برقراری ارتباط با سرور",
                )
            }
        }
    }

    private fun getCategory(){
        viewModelScope.launch {
            _homeState.value = _homeState.value.copy(isLoading = true, errorMessage = null)
            try {
                val categories = productUseCase.getCategories()
                _homeState.value = _homeState.value.copy(
                    categories = categories,
                    isLoading = false,
                )
            } catch (e: Exception) {

                e.printStackTrace()
                _homeState.value = _homeState.value.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "خطا در برقراری ارتباط با سرور",
                )
            }
        }
    }
}
