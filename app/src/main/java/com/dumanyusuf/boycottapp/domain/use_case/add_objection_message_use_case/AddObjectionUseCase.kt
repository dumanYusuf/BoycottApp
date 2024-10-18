package com.dumanyusuf.boycottapp.domain.use_case.add_objection_message_use_case

import com.dumanyusuf.boycottapp.domain.model.UsersNotification
import com.dumanyusuf.boycottapp.domain.repo.BoykotRepo
import com.dumanyusuf.boycottapp.util.Resource
import javax.inject.Inject

class AddObjectionUseCase @Inject constructor(private val repo: BoykotRepo) {

    suspend operator fun invoke(note:UsersNotification):Resource<UsersNotification>{
        return repo.addObjectionMessage(note)
    }

}