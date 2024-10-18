package com.dumanyusuf.boycottapp.data.di

import com.dumanyusuf.boycottapp.data.repo.BoykotRepoImpl
import com.dumanyusuf.boycottapp.domain.repo.BoykotRepo
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesFirebase():FirebaseFirestore=FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun providesRepo(firestore:FirebaseFirestore):BoykotRepo{
        return BoykotRepoImpl(firestore)
    }

}