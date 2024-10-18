package com.dumanyusuf.boycottapp.presentation.home_page_view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dumanyusuf.boycottapp.domain.use_case.get_filter_products_use_case.GetFilterProductsUseCase
import com.dumanyusuf.boycottapp.domain.use_case.get_products_in_category_use_case.GetProductsInCategoryUseCase
import com.dumanyusuf.boycottapp.domain.use_case.get_products_use_case.GetProductsUseCase
import com.dumanyusuf.boycottapp.domain.use_case.search_products_use_case.SearchProductsUseCase
import com.dumanyusuf.boycottapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getFilterProductsUseCase: GetFilterProductsUseCase,
    private val getSearchProductsUseCase: SearchProductsUseCase,
    private val getProductsInCategoryUseCase: GetProductsInCategoryUseCase
):ViewModel() {


    private val _state= MutableStateFlow<HomeState>(HomeState())
    val state:StateFlow<HomeState> = _state

   /* fun loadAllProducts(){
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
    }*/


    fun loadAllINProducts(){
        viewModelScope.launch {
            _state.value=HomeState(isLoading = true)
            getProductsInCategoryUseCase.getProductInCategory().collect{resultProducts->
                when(resultProducts){
                    is Resource.Success->{
                        _state.value=HomeState(productList = resultProducts.data?: emptyList())
                        Log.e("success products in category","success get products:${resultProducts.data}")
                    }
                    is Resource.Error->{
                        _state.value=HomeState(isError = "errror")
                        Log.e("erorr products in category","error get products:${resultProducts.message}")
                    }
                    is Resource.Loading->{
                        _state.value=HomeState(isLoading = true)
                        Log.e("loading products in category","loading get products")
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


    fun searchProduct(search:String){
        viewModelScope.launch {
            _state.value=HomeState(isLoading = true)
            getSearchProductsUseCase.searchProducts(search).collect{resultProducts->
                when(resultProducts){
                    is Resource.Success->{
                        _state.value=HomeState(productList = resultProducts.data?: emptyList())
                        Log.e("success products search ","success get search products:${resultProducts.data}")
                    }
                    is Resource.Error->{
                        _state.value=HomeState(isError = "errror")
                        Log.e("erorr products search ","error get search products:${resultProducts.message}")
                    }
                    is Resource.Loading->{
                        _state.value=HomeState(isLoading = true)
                        Log.e("loading products search","loading get search products")
                    }
                }
            }
        }
    }


}