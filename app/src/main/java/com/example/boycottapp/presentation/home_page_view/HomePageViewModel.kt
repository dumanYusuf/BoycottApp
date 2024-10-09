package com.example.boycottapp.presentation.home_page_view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boycottapp.domain.model.Products
import com.example.boycottapp.domain.use_case.get_filter_products_use_case.GetFilterProductsUseCase
import com.example.boycottapp.domain.use_case.get_products_use_case.GetProductsUseCase
import com.example.boycottapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getFilterProductsUseCase: GetFilterProductsUseCase
):ViewModel() {


    private val _state= MutableStateFlow<HomeState>(HomeState())
    val state:StateFlow<HomeState> = _state

    fun loadAllProducts(){
        viewModelScope.launch {
            _state.value=HomeState(isLoading = true)
            getProductsUseCase.getProducts().collect{resultProducts->
                when(resultProducts){
                    is Resource.Success->{
                        _state.value=HomeState(productList = resultProducts.data?: emptyList())
                        Log.e("success products","success get products:${resultProducts.data}")
                    }
                    is Resource.Error->{
                        _state.value=HomeState(isError = "errror")
                        Log.e("erorr products","error get products:${resultProducts.message}")
                    }
                    is Resource.Loading->{
                        _state.value=HomeState(isLoading = true)
                        Log.e("loading products","loading get products")
                    }
                }
            }
        }
    }

    fun loadFilterProducts(status:String){
        viewModelScope.launch {
            _state.value=HomeState(isLoading = true)
            getFilterProductsUseCase.getFilterProductsUseCase(status).collect{resultProducts->
                when(resultProducts){
                    is Resource.Success->{
                        _state.value=HomeState(productList = resultProducts.data?: emptyList())
                        Log.e("success products","success get products:${resultProducts.data}")
                    }
                    is Resource.Error->{
                        _state.value=HomeState(isError = "errror")
                        Log.e("erorr products","error get products:${resultProducts.message}")
                    }
                    is Resource.Loading->{
                        _state.value=HomeState(isLoading = true)
                        Log.e("loading products","loading get products")
                    }
                }
            }
        }
    }

}