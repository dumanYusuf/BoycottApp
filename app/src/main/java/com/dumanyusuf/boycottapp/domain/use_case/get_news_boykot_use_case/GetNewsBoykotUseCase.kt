package com.dumanyusuf.boycottapp.domain.use_case.get_news_boykot_use_case

import com.dumanyusuf.boycottapp.domain.model.News
import com.dumanyusuf.boycottapp.domain.repo.BoykotRepo
import com.dumanyusuf.boycottapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsBoykotUseCase @Inject constructor(private val repo: BoykotRepo) {


    suspend fun getNews():Flow<Resource<List<News>>>{
        return repo.getNewsBoykot()
    }

}