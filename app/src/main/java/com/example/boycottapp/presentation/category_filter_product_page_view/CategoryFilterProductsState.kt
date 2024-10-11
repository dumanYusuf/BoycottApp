package com.example.boycottapp.presentation.category_filter_product_page_view

import com.example.boycottapp.domain.model.Products

data class CategoryFilterProductsState(
    val productList:List<Products> = emptyList(),
    val isLoading:Boolean=false,
    val isError:String=""
)
