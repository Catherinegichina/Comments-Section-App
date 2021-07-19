package com.example.myposts

import retrofit2.http.Body

data class Comments(
    var name:String,
    var id:Int,
    var email:String,
    var body: String,
    var post_id:Int
)
