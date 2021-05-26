package com.example.resizemenu.ui.user_info

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resizemenu.R
import com.example.resizemenu.domain.models.User

class UserInfoAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private var arrayList: ArrayList<User> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_info, parent, false),
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(arrayList.get(position))
    }

    override fun getItemCount(): Int = arrayList.size
    fun setNewList(users: List<User>) {
    //    this.arrayList= users
        arrayList.addAll(users)
        notifyDataSetChanged()

        Log.d("myApp","users.length:"+users.size);
    }

}