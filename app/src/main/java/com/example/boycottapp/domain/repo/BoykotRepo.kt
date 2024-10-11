package com.example.boycottapp.domain.repo

import com.example.boycottapp.domain.model.Category
import com.example.boycottapp.domain.model.Products
import com.example.boycottapp.util.Resource
import kotlinx.coroutines.flow.Flow


interface BoykotRepo {

    suspend fun getProduct():Flow<Resource<List<Products>>>
    suspend fun getBoycotAndUygunProducts(status:String):Flow<Resource<List<Products>>>
    suspend fun searchProduct(search:String):Flow<Resource<List<Products>>>
    suspend fun getCategory():Flow<Resource<List<Category>>>
    suspend fun getCategoryFilterProductPage(id:String):Flow<Resource<List<Products>>>
}