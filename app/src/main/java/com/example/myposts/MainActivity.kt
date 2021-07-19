package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
//    casting he recycler view below.
     lateinit var rvPost:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPosts()
    }
    fun getPosts(){
        var rvPosts=findViewById<RecyclerView>(R.id.rvposts)
        val retrofit=ApiClient.buildAppClient(ApiInterface::class.java)
//        creating an instance of retrofit.Pass the apiinterface.
        val request=retrofit.getPosts()
//        where the call actually takes place.
        request.enqueue(object : Callback, retrofit2.Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>?>, response: Response<List<Post>?>) {
              if(response.isSuccessful){
                  var posts=response.body()!!
                  var myAdapter=MyPosts(baseContext,posts)
//                  yake ni postsAdapter.
                  rvPosts.adapter=myAdapter
//                  setting the posts to the adapter.
                  rvPosts.layoutManager=LinearLayoutManager(baseContext)
//                  the response is returned to this function.this function is called(n vise versa)
//                  ?-a  null value./no data/no value.Catering for-a send is successful but no request back.
//                  no possibility for it to be null-list!!
                  Toast.makeText(baseContext,posts?.size.toString(),Toast.LENGTH_SHORT).show()
//                  accessing the variables.
              }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
//                to show the error.

            }


        })
}}