package com.dumanyusuf.boycottapp.presentation.gemini_page_view

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dumanyusuf.boycottapp.domain.model.Message
import com.dumanyusuf.boycottapp.util.Constans
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.ResponseStoppedException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeminiViewModel @Inject constructor():ViewModel() {


    val messageList by lazy { mutableStateListOf<Message>() }

    val generateViewModel:GenerativeModel=GenerativeModel(
        modelName = "gemini-pro",
        apiKey = Constans.api_key
    )

    fun sendMessage(question: String) {
        viewModelScope.launch {
            try {
                // kullanıcının gönderdiği mesaj
                val chat = generateViewModel.startChat()
                messageList.add(Message(question, "user"))

                // chatin gönderdiği mesaj
                val response = chat.sendMessage(question)
                messageList.add(Message(response.text.toString(), "assistant"))

                Log.e("GeminiPageView", response.text.toString())
            } catch (e: ResponseStoppedException) {
                Log.e("Chat Error", "Message stopped due to safety reasons: ${e.message}")
                messageList.add(Message("Sorry, your message couldn't be processed.", "assistant"))
            } catch (e: Exception) {
                Log.e("Chat Error", "An unexpected error occurred: ${e.message}")
                messageList.add(Message("An error occurred. Please try again.", "assistant"))
            }
        }
    }


}