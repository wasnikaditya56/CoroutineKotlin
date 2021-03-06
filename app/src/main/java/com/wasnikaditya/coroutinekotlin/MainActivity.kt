package com.wasnikaditya.coroutinekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wasnikaditya.coroutinekotlin.Adapter.PostAdapter
import com.wasnikaditya.coroutinekotlin.Model.Post
import com.wasnikaditya.coroutinekotlin.Repository.PostRepository
import com.wasnikaditya.coroutinekotlin.ViewModel.PostViewModel
import com.wasnikaditya.coroutinekotlin.ViewModel.PostViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var postRepository: PostRepository
    private lateinit var postViewModelFactory: PostViewModelFactory
    private lateinit var postViewModel: PostViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        postRepository = PostRepository()
        postViewModelFactory = PostViewModelFactory(postRepository)
        postViewModel = ViewModelProvider(this,postViewModelFactory).get(PostViewModel::class.java)

        postViewModel.getPost()

        postViewModel.myResponse.observe(this, Observer {
            postAdapter.setPostData(it as ArrayList<Post>)
            Log.d("main", it[0].title)
            progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        })
    }

    private fun initRecyclerView()
    {
        recyclerView = findViewById(R.id.recyclerView)
        postAdapter = PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=postAdapter
        }
    }

}