package com.dumanyusuf.boycottapp.presentation.news_page_view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dumanyusuf.boycottapp.domain.use_case.get_news_boykot_use_case.GetNewsBoykotUseCase
import com.dumanyusuf.boycottapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsBoykotUseCase: GetNewsBoykotUseCase):ViewModel() {


    private val _state= MutableStateFlow<NewsState>(NewsState())
    val state:StateFlow<NewsState> = _state

    fun loadNewsBoykot(){
        viewModelScope.launch {
            _state.value= NewsState(isLoading = true)
            getNewsBoykotUseCase.getNews().collect{
                when(it){
                    is Resource.Success->{
                        _state.value=NewsState(newsList = it.data?: emptyList())
                        Log.e("success news","sucecccsss newss:${it.data}")
                    }
                    is Resource.Error->{
                        _state.value=NewsState(isError = "Erorr")
                        Log.e("error news","error newss:${it.message}")
                    }
                    is Resource.Loading->{
                        _state.value=NewsState(isLoading = true)
                        Log.e("loading news","loading newss")
                    }
                }
            }
        }
    }

}