package com.example.retro1.Presentation.Login.Presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.retro1.Presentation.Login.APIClient
import com.example.retro1.Presentation.Login.CommentsRepository
import com.example.retro1.Presentation.Login.models.MainState
import kotlinx.coroutines.launch


class CommentsViewModel(

private val repository: CommentsRepository = CommentsRepository(APIClient.instance)
): ViewModel(){

    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {

            state = state.copy(isLoading = true)

            repository.getInfo().onSuccess {
                    state = state.copy(
                    comments = it
                    )


            }.onFailure {
                    println()
            }

            state = state.copy(isLoading = false)
        }
    }
}