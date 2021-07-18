package com.example.myposts

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var retrofit=Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/posts")
//    add that call to hii ya chini.
        .addConverterFactory(GsonConverterFactory.create())
//     craeting a system of our api client
        .build()
    fun <T> buildAppClient(apiInterface: Class<T>):T{
        return retrofit.create(apiInterface)
//        a return type of any type.
//     t-a generic function.
    }
}