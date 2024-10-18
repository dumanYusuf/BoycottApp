package com.dumanyusuf.boycottapp.domain.repo

import com.dumanyusuf.boycottapp.domain.model.Category
import com.dumanyusuf.boycottapp.domain.model.News
import com.dumanyusuf.boycottapp.domain.model.Products
import com.dumanyusuf.boycottapp.domain.model.UsersNotification
import com.dumanyusuf.boycottapp.util.Resource
import kotlinx.coroutines.flow.Flow


interface BoykotRepo {

    suspend fun getProduct():Flow<Resource<List<Products>>>
    suspend fun getBoycotAndUygunProducts(status:String):Flow<Resource<List<Products>>>
    suspend fun searchProduct(search:String):Flow<Resource<List<Products>>>
    suspend fun getCategory():Flow<Resource<List<Category>>>
    suspend fun getCategoryFilterProductPage(id:String):Flow<Resource<List<Products>>>
    suspend fun getNewsBoykot():Flow<Resource<List<News>>>
    suspend fun addSuggestionMessage(note:UsersNotification):Resource<UsersNotification>
    suspend fun addObjectionMessage(note: UsersNotification):Resource<UsersNotification>
    suspend fun getProductInCategory():Flow<Resource<List<Products>>>
}