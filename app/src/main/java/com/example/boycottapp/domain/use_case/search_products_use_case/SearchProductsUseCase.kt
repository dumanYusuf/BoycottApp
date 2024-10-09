package com.example.boycottapp.domain.use_case.search_products_use_case

import com.example.boycottapp.domain.model.Products
import com.example.boycottapp.domain.repo.BoykotRepo
import com.example.boycottapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchProductsUseCase @Inject constructor(private val repo: BoykotRepo) {

    suspend fun searchProducts(search:String):Flow<Resource<List<Products>>>{
        return repo.searchProduct(search)
    }

}