package com.wasnikaditya.coroutinekotlin.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wasnikaditya.coroutinekotlin.Model.Post
import com.wasnikaditya.coroutinekotlin.Repository.PostRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {

    val myResponse:MutableLiveData<List<Post>> = MutableLiveData()
    fun getPost()
    {
        viewModelScope.launch {
            try {
                val response = postRepository.getPost()
                myResponse.value = response
            }catch(e:Exception){
                Log.d("main", "getPost: ${e.message}")
            }
        }
    }

}