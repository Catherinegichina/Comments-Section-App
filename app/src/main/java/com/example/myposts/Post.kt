package com.example.myposts

import android.icu.text.CaseMap

data class Post(
    var userId:Int,
    var id:Int,
    var title: String,
    var body : String
)
