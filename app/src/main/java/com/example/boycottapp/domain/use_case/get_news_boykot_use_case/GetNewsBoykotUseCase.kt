package com.example.boycottapp.domain.use_case.get_news_boykot_use_case

import com.example.boycottapp.domain.model.News
import com.example.boycottapp.domain.repo.BoykotRepo
import com.example.boycottapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsBoykotUseCase @Inject constructor(private val repo: BoykotRepo) {


    suspend fun getNews():Flow<Resource<List<News>>>{
        return repo.getNewsBoykot()
    }

}