package com.example.myposts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class commentsAdapter(var comments:List<Comments>):RecyclerView.Adapter<commentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): commentsViewHolder {
        var  commentsList=LayoutInflater.from(parent.context).inflate(R.layout.comments,parent,false)
//        attaching to root.
        return commentsViewHolder(commentsList)
    }

    override fun onBindViewHolder(holder: commentsViewHolder, position: Int) {
     var newComments=comments.get(position)
        holder.tvname.text=newComments.name
        holder.tvbody.text=newComments.body
        holder.tvemail.text=newComments.email
//        equating for access.
    }

    override fun getItemCount(): Int {
        return comments.size
    }

}
class commentsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvname=itemView.findViewById<TextView>(R.id.tvname)
    var tvemail=itemView.findViewById<TextView>(R.id.tvemail)
    var tvbody=itemView.findViewById<TextView>(R.id.tvbody)
}