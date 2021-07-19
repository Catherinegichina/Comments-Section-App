package com.example.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface{
    @GET("posts")
//    end-point.
    fun getPosts(): Call<List<Post>>
//    call is the return type n returns a list of post objects.

    @GET("posts/{postId}")
        fun getPost(@Path( "postId")postId:Int):Call<Post>
    @GET("posts/{postsId}/comments")
    fun getComments(@Path("postId")id:Int):Call<List<Comments>>
}


