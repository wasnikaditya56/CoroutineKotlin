package com.wasnikaditya.coroutinekotlin.Network

import com.wasnikaditya.coroutinekotlin.Model.Post
import retrofit2.http.GET

interface Api
{
    @GET("posts")
    suspend fun getAllPost(): List<Post>
}