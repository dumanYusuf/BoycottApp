package com.example.boycottapp.domain.repo

import com.example.boycottapp.domain.model.Category
import com.example.boycottapp.domain.model.News
import com.example.boycottapp.domain.model.Products
import com.example.boycottapp.domain.model.UsersNotification
import com.example.boycottapp.util.Resource
import com.google.firebase.firestore.auth.User
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
}