package com.wasnikaditya.coroutinekotlin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wasnikaditya.coroutinekotlin.Model.Post
import com.wasnikaditya.coroutinekotlin.R


class PostAdapter(private val context:Context, private var postList: ArrayList<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
           PostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent,false))

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        val post = postList[position]
        holder.id.text = post.id.toString()
        holder.title.text = post.title
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val id: TextView = itemView.findViewById(R.id.id)
        val title: TextView = itemView.findViewById(R.id.title)
    }

    fun setPostData(postList: ArrayList<Post>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }
}