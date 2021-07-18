package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    var postId=0
    lateinit var tvPostTitle:TextView
    lateinit var tvPostody:TextView
//    to access it outside classes.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)
//        where we will set the onclick.
        postId=intent.getIntExtra("POST_ID",0)
//    getInXtra-0 is wheb the id is not found.
    }
    fun castViews(){
        tvPostTitle=findViewById(R.id.tvPostTittle)
        tvPostody=findViewById(R.id.tvBody)
    }
    fun getPost(){
        if (postId==0){
        Toast.makeText(baseContext,"Post not found",Toast.LENGTH_LONG).show()
            finish()
    }
        var apiClient=ApiClient.buildAppClient(ApiInterface::class.java)
        var request=apiClient.getPost(postId)
        request.enqueue(object :Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if(response.isSuccessful){
                    var post=response.body()
                    tvPostTitle.text=post?.title
                    tvPostody.text=post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
              Toast.makeText(baseContext,"failure",Toast.LENGTH_LONG).show()
            }
        })

}}