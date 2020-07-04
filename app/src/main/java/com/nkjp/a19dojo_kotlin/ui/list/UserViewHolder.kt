package com.nkjp.a19dojo_kotlin.ui.list

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nkjp.a19dojo_kotlin.R

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var nameView: TextView
    var twitterView: TextView
    var githubView: TextView
    var imageViewTw: ImageView
    var imageViewGh: ImageView

    init {
        nameView = itemView.findViewById(R.id.name)
        twitterView = itemView.findViewById(R.id.twitter)
        githubView = itemView.findViewById(R.id.github)
        imageViewTw = itemView.findViewById(R.id.imageViewTw)
        imageViewGh = itemView.findViewById(R.id.imageViewGh)
    }
}