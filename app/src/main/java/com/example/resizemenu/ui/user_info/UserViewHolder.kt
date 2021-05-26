package com.example.resizemenu.ui.user_info

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.resizemenu.R
import com.example.resizemenu.domain.models.User

class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private var userNameTextView:TextView = itemView.findViewById<TextView>(R.id.user_name)
    private var userEmailTextView:TextView =itemView.findViewById<TextView>(R.id.user_email)
    private var avatar: ImageView = itemView.findViewById<ImageView>(R.id.avatar_imageview)

    fun onBind(user: User) {
        userNameTextView.setText(user.name)
        userEmailTextView.setText(user.email)
        Glide.with(itemView.context).load(user.avatar).into(avatar)

    }
}