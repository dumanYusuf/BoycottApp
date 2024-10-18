package com.dumanyusuf.boycottapp.presentation.category_page_view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dumanyusuf.boycottapp.domain.use_case.get_category_use_case.GetCategoryUseCase
import com.dumanyusuf.boycottapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor(private val getCategoryUseCase: GetCategoryUseCase):ViewModel() {


    private val _state= MutableStateFlow<CategoryState>(CategoryState())
    val state: StateFlow<CategoryState> = _state


    fun loadCategory(){
        viewModelScope.launch {
            _state.value=CategoryState(isLoading = true)
            getCategoryUseCase.getCategory().collect{categoryList->
                when(categoryList){
                    is Resource.Success->{
                        _state.value=CategoryState(categorytList = categoryList.data?: emptyList())
                        Log.e("succecss category","success get category")
                    }
                    is Resource.Error->{
                        _state.value=CategoryState(isError = "Error")
                        Log.e("error category","error get category:${categoryList.message}")
                    }
                    is Resource.Loading->{
                        _state.value=CategoryState(isLoading = true)
                        Log.e("load category","load get category")
                    }
                }
            }
        }
    }

}