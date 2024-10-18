package com.dumanyusuf.boycottapp.presentation.category_filter_product_page_view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dumanyusuf.boycottapp.domain.use_case.get_category_filter_products_use_case.GetCategoryFilterProductUseCase
import com.dumanyusuf.boycottapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoryFilterProductViewModel @Inject constructor(private val categoryFilterProductUseCase: GetCategoryFilterProductUseCase):ViewModel(){

    private val _state= MutableStateFlow<CategoryFilterProductsState>(CategoryFilterProductsState())
    val state:StateFlow<CategoryFilterProductsState> =_state

    fun loadCategoryFilterProduct(id:String){
        viewModelScope.launch {
            _state.value=CategoryFilterProductsState(isLoading = true)
            categoryFilterProductUseCase.getFilterCategoryFilterProducts(id).collect{
                when(it){
                    is Resource.Success->{
                        _state.value=CategoryFilterProductsState(productList = it.data?: emptyList())
                        Log.e("succecc loadCategoryFilterProduct","loadCategoryFilterProduct sucecc")
                    }
                    is Resource.Error->{
                        _state.value=CategoryFilterProductsState(isError = "Error")
                        Log.e("Error loadCategoryFilterProduct","loadCategoryFilterProduct errror:${it.message}")
                    }
                    is Resource.Loading->{
                        _state.value=CategoryFilterProductsState(isLoading = true)
                        Log.e("loading loadCategoryFilterProduct","loadCategoryFilterProduct loading")
                    }
                }
            }
        }
    }

}