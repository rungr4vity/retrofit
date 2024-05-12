package com.example.retro1.Presentation.Login

import com.example.retro1.Presentation.Login.models.commentsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface APIClient{

    companion object {
        val instance = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()
            ).build().create(APIClient::class.java)
    }

    @GET("comments")
    suspend fun getInfo(): commentsResponse

}