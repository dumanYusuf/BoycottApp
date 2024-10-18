package com.dumanyusuf.boycottapp.domain.use_case.get_category_use_case

import com.dumanyusuf.boycottapp.domain.model.Category
import com.dumanyusuf.boycottapp.domain.repo.BoykotRepo
import com.dumanyusuf.boycottapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(private val repo: BoykotRepo) {

    suspend fun getCategory():Flow<Resource<List<Category>>>{
        return repo.getCategory()
    }

}