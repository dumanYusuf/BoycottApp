package com.dumanyusuf.boycottapp.presentation.news_page_view

import com.dumanyusuf.boycottapp.domain.model.News

data class NewsState(
    val newsList:List<News> = emptyList(),
    val isLoading:Boolean=false,
    val isError:String=""
)
