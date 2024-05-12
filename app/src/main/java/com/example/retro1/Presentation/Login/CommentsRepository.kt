package com.example.retro1.Presentation.Login

import com.example.retro1.Presentation.Login.models.commentsResponseItem
import com.example.retro1.Presentation.Login.models.small

class CommentsRepository(
    private val api: APIClient
) {

    suspend fun getInfo(): Result<List<small>>{

        return try {
            val response = api.getInfo()
            val data = response.map { converter(it) }

            Result.success(data)
        } catch (e: Exception){

            Result.failure(e)
            //emptyList()
        }
    }

    fun converter(data: commentsResponseItem): small {
        return small(
            data.email,
            data.id
        )
    }
}