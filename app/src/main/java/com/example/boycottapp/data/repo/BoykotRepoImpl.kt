package com.example.boycottapp.data.repo

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
}