package com.dumanyusuf.boycottapp.domain.use_case.get_filter_products_use_case

import com.dumanyusuf.boycottapp.domain.model.Products
import com.dumanyusuf.boycottapp.domain.repo.BoykotRepo
import com.dumanyusuf.boycottapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFilterProductsUseCase @Inject constructor(private val repo: BoykotRepo) {

    suspend fun getFilterProductsUseCase(status:String): Flow<Resource<List<Products>>>{
        return repo.getBoycotAndUygunProducts(status)
    }

}