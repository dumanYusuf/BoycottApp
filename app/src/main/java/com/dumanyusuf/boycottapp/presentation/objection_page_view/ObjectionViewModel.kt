package com.dumanyusuf.boycottapp.presentation.objection_page_view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dumanyusuf.boycottapp.domain.model.UsersNotification
import com.dumanyusuf.boycottapp.domain.use_case.add_objection_message_use_case.AddObjectionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ObjectionViewModel @Inject constructor(private val addObjectionUseCase: AddObjectionUseCase):ViewModel() {

    private val _state= MutableStateFlow<ObjectionState>(ObjectionState())
    val state:StateFlow<ObjectionState> =_state


    fun objectionMessage(note:UsersNotification){
        viewModelScope.launch {
            addObjectionUseCase.invoke(note)
            Log.e("success objection","succsess objection notes message")
        }
    }

}