package com.example.retro1.Presentation.Login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.retro1.Presentation.Login.Presentation.CommentsViewModel


@Composable
fun LoginView(viewModel: CommentsViewModel) {

    val state = viewModel.state


    if (state.isLoading){
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }


    if (state.comments.isNotEmpty()){
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.comments){
                Text(text = it.email)
            }
        }
    }




}