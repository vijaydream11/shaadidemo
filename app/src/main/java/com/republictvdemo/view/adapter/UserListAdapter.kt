package com.republictvdemo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.republictvdemo.R
import com.republictvdemo.utility.loadImage
import com.republictvdemo.view.ui.UserUI
import kotlinx.android.synthetic.main.row_user_type_1.view.*
import kotlinx.android.synthetic.main.row_user_type_2.view.*

class UserListAdapter(
    private val userList: ArrayList<UserUI>,
    val userItemClickListener: UserItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_1 = 0
    private val TYPE_2 = 1

    override fun getItemViewType(position: Int): Int {
        return when (position % 2) {
            0 -> TYPE_1
            else -> TYPE_2
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_1 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.row_user_type_1, parent, false)
                User1ViewHolder(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.row_user_type_2, parent, false)
                User2ViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_1 -> (holder as User1ViewHolder).bind(userList[position])
            else -> (holder as User2ViewHolder).bind(userList[position])
        }
    }

    inner class User1ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun bind(user: UserUI) {
            itemView.txt_user_name.text = "${user.firstName.toUpperCase()} ${user.lastName.toUpperCase()}"
            itemView.txt_user_email.text = "${user.userEmail}"
            itemView.img_user.loadImage(user.profileLarge, R.drawable.ic_profile)

            itemView.setOnClickListener { userItemClickListener.onItemClick(adapterPosition, user) }
        }
    }

    inner class User2ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        fun bind(user: UserUI) {
            itemView.txt_user_name_2.text = "${user.firstName.toUpperCase()} ${user.lastName.toUpperCase()}"
            itemView.txt_user_email_2.text = "${user.userEmail}"
            itemView.img_user_2.loadImage(user.profileLarge, R.drawable.ic_profile)

            itemView.setOnClickListener { userItemClickListener.onItemClick(adapterPosition, user) }
        }
    }

    interface UserItemClickListener {
        fun onItemClick(position: Int, user: UserUI)
    }

}