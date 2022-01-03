package com.wasnikaditya.coroutinekotlin.Repository

import com.wasnikaditya.coroutinekotlin.Model.Post
import com.wasnikaditya.coroutinekotlin.Network.RetrofitBuilder

class PostRepository {

    suspend fun getPost(): List<Post> = RetrofitBuilder.api.getAllPost()
}