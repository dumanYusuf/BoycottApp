package com.dumanyusuf.boycottapp.presentation.suggestion_page_view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dumanyusuf.boycottapp.domain.model.UsersNotification
import com.dumanyusuf.boycottapp.domain.use_case.add_suggestion_message_use_case.AddSuggestionMessageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SuggestionViewModel @Inject constructor(private val addSuggestionMessageUseCase: AddSuggestionMessageUseCase):ViewModel() {


    private val _state= MutableStateFlow<SuggestionState>(SuggestionState())
    val state:StateFlow<SuggestionState> = _state

    fun addSuggestionMessage(note:UsersNotification){
        viewModelScope.launch {
            addSuggestionMessageUseCase.addSuggestionMessage(note)
            Log.e("success aded","sucess add notes")
        }
    }

}