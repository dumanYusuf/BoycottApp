package com.example.boycottapp.data.repo

import com.example.boycottapp.domain.model.Category
import com.example.boycottapp.domain.model.Products
import com.example.boycottapp.domain.repo.BoykotRepo
import com.example.boycottapp.util.Resource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class BoykotRepoImpl @Inject constructor(private val firestore: FirebaseFirestore):BoykotRepo {


    override suspend fun getProduct(): Flow<Resource<List<Products>>> = flow{
        try {
            val producDocRef=firestore.collection("Products").get().await()
            val productList=producDocRef.documents.mapNotNull {
                it.toObject(Products::class.java)
            }
            emit(Resource.Success(productList))
        }
        catch (e:Exception){
            emit(Resource.Error("Error:${e.message}"))
        }
    }

    override suspend fun getBoycotAndUygunProducts(status: String): Flow<Resource<List<Products>>> = flow {
        try {
            val productQuery = firestore.collection("Products")
                .whereEqualTo("productStatus", status).get().await()

            val productList = productQuery.documents.mapNotNull {
                it.toObject(Products::class.java)
            }

            emit(Resource.Success(productList))
        } catch (e: Exception) {
            emit(Resource.Error("Error: ${e.message}"))
        }
    }

    override suspend fun searchProduct(search: String): Flow<Resource<List<Products>>> = flow {
        try {
            val producDocRef=firestore.collection("Products").get().await()
            val searchList = producDocRef.documents.mapNotNull { document ->
                document.toObject(Products::class.java)?.takeIf { product ->
                    product.productName.contains(search, ignoreCase = true)
                }
            }
            emit(Resource.Success(searchList))
        }
        catch (e:Exception){
            emit(Resource.Error("Error:${e.message}"))
        }
    }

    override suspend fun getCategory(): Flow<Resource<List<Category>>> = flow{
        try {
            val categoryDocRef=firestore.collection("Category").get().await()
            val categoryList=categoryDocRef.documents.mapNotNull {
                it.toObject(Category::class.java)
            }
            emit(Resource.Success(categoryList))
        }
        catch (e:Exception){
            emit(Resource.Error("Error:${e.message}"))
        }
    }

}