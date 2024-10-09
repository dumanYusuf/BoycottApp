package com.example.boycottapp.domain.repo

import com.example.boycottapp.domain.model.Products
import com.example.boycottapp.util.Resource
import kotlinx.coroutines.flow.Flow


interface BoykotRepo {

    suspend fun getProduct():Flow<Resource<List<Products>>>

}