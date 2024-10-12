package com.example.boycottapp.domain.use_case.add_suggestion_message_use_case

import com.example.boycottapp.domain.model.UsersNotification
import com.example.boycottapp.domain.repo.BoykotRepo
import com.example.boycottapp.util.Resource
import javax.inject.Inject

class AddSuggestionMessageUseCase @Inject constructor(private val repo: BoykotRepo) {

    suspend fun addSuggestionMessage(note:UsersNotification):Resource<UsersNotification>{
        return repo.addSuggestionMessage(note)
    }

}