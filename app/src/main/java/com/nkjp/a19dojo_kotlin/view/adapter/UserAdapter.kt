package com.nkjp.a19dojo_kotlin.view.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.nkjp.a19dojo_kotlin.R
import com.nkjp.a19dojo_kotlin.view.ui.activity.WebViewActivity
import com.nkjp.a19dojo_kotlin.model.User
import com.nkjp.a19dojo_kotlin.model.UserViewHolder

class UserAdapter(private val users: List<User>, private val context: Context) :
    RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.nameView.text = users[position].name
        holder.twitterView.text = users[position].twitter
        holder.githubView.text = users[position].github

        holder.imageViewTw.setOnClickListener {
            val twitterUri = "https://twitter.com/${users[position].twitter}".toUri()
            val intent = Intent(context, WebViewActivity::class.java)
            Log.d("TEST2", twitterUri.toString())
            intent.putExtra("FLAG", twitterUri.toString())
            context.startActivity(intent)
        }
        holder.imageViewGh.setOnClickListener {
            val githubUri = "https://github.com/${users[position].github}".toUri()
            val intent = Intent(context, WebViewActivity::class.java)
            Log.d("TEST2", githubUri.toString())
            intent.putExtra("FLAG", githubUri.toString())
            context.startActivity(intent)
        }

    }


}