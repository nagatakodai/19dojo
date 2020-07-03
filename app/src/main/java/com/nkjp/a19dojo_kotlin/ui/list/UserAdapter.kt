package com.nkjp.a19dojo_kotlin.ui.list

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.nkjp.a19dojo_kotlin.R
import com.nkjp.a19dojo_kotlin.WebViewActivity
import com.nkjp.a19dojo_kotlin.ui.qr.User

class UserAdapter(private val users: List<User> , private val context: Context) : RecyclerView.Adapter<UserViewHolder>() {

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
            val intent = Intent(context,WebViewActivity::class.java)
            intent.putExtra("FLAG",twitterUri.toString())
            Log.d("uri",twitterUri.toString())
            context.startActivity(intent)
        }
        holder.imageViewGh.setOnClickListener {
            val githubUri = "https://github.com/${users[position].github}".toUri()
            var intent = Intent(context,WebViewActivity::class.java)
            intent.putExtra("FLAG",githubUri)
            context.startActivity(intent)
        }

    }


}