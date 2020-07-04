package com.nkjp.a19dojo_kotlin.model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nkjp.a19dojo_kotlin.R

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var nameView: TextView = itemView.findViewById(R.id.name)
    var twitterView: TextView = itemView.findViewById(R.id.twitter)
    var githubView: TextView = itemView.findViewById(R.id.github)
    var imageViewTw: ImageView = itemView.findViewById(R.id.imageViewTw)
    var imageViewGh: ImageView = itemView.findViewById(R.id.imageViewGh)

}