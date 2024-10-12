package com.example.boycottapp.domain.use_case.add_objection_message_use_case

import com.example.boycottapp.domain.model.UsersNotification
import com.example.boycottapp.domain.repo.BoykotRepo
import com.example.boycottapp.util.Resource
import com.google.firebase.firestore.auth.User
import javax.inject.Inject

class AddObjectionUseCase @Inject constructor(private val repo: BoykotRepo) {

    suspend operator fun invoke(note:UsersNotification):Resource<UsersNotification>{
        return repo.addObjectionMessage(note)
    }

}