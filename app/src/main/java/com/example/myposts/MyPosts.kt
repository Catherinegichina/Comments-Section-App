package com.example.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyPosts(var context: Context,var userList:List<Post>):RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):PostViewHolder{
        var itemView=LayoutInflater.from(context).inflate(R.layout.row_items,parent,false)
        return PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.tvUserId.text=userList[position].userId.toString()
        holder.tvId.text=userList[position].id.toString()
        holder.tvTitle.text=userList[position].title
        holder.tvBody.text=userList[position].body
        holder.cvPost.setOnClickListener{
            var intent=Intent(context,CommentsActivity::class.java)
            intent.putExtra("POST_ID",0)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
//        return postsList.size.
    }
}
class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
//    without the import,we write like the one above--RecylerView.ViewHolder.
    var tvUserId=itemView.findViewById<TextView>(R.id.tvUserId)
    var tvId=itemView.findViewById<TextView>(R.id.tvId)
    var tvTitle=itemView.findViewById<TextView>(R.id.tvTittle)
    var tvBody=itemView.findViewById<TextView>(R.id.tvBody)
    var cvPost=itemView.findViewById<CardView>(R.id.cvPost)
}