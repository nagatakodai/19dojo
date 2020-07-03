package com.nkjp.a19dojo_kotlin.ui.list

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nkjp.a19dojo_kotlin.R
import com.nkjp.a19dojo_kotlin.ui.qr.User

class UserAdapter(private var users: List<User>) : RecyclerView.Adapter<UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return UserViewHolder(view)
    }
    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.nameView.text = users[position].name
        holder.twitterView.text = users[position].twitter
        holder.githubView.text = users[position].github

/*        holder.imageViewTw!!.setOnClickListener {
            val twitterUri = "https://twitter.com/${users[position].twitter}".toUri()
            openCustomTabs(holder.view.twitterButton.context, twitterUri)
        }
        holder.imageViewGh!!.setOnClickListener {
            val githubUri = "https://github.com/${users[position].github}".toUri()
            openCustomTabs(holder.view.githubButton.context, githubUri)
        }

*/
    }


}