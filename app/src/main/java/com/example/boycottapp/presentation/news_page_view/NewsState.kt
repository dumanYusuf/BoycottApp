package com.example.boycottapp.presentation.news_page_view

import com.example.boycottapp.domain.model.Products

data class NewsState(
   // val newsList:List<News> = emptyList(),
    val isLoading:Boolean=false,
    val isError:String=""
)
