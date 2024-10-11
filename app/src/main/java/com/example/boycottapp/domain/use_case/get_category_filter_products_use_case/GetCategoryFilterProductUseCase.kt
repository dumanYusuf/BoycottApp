package com.example.boycottapp.domain.use_case.get_category_filter_products_use_case

import com.example.boycottapp.domain.model.Products
import com.example.boycottapp.domain.repo.BoykotRepo
import com.example.boycottapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoryFilterProductUseCase @Inject constructor(private val repo: BoykotRepo) {

    suspend fun getFilterCategoryFilterProducts(id:String):Flow<Resource<List<Products>>>{
        return repo.getCategoryFilterProductPage(id)
    }

}