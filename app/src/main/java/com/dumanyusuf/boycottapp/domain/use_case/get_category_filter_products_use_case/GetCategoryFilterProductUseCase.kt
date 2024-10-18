package com.dumanyusuf.boycottapp.domain.use_case.get_category_filter_products_use_case

import com.dumanyusuf.boycottapp.domain.model.Products
import com.dumanyusuf.boycottapp.domain.repo.BoykotRepo
import com.dumanyusuf.boycottapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoryFilterProductUseCase @Inject constructor(private val repo: BoykotRepo) {

    suspend fun getFilterCategoryFilterProducts(id:String):Flow<Resource<List<Products>>>{
        return repo.getCategoryFilterProductPage(id)
    }

}