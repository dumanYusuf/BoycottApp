package com.dumanyusuf.boycottapp.presentation.category_filter_product_page_view

import com.dumanyusuf.boycottapp.domain.model.Products

data class CategoryFilterProductsState(
    val productList:List<Products> = emptyList(),
    val isLoading:Boolean=false,
    val isError:String=""
)
