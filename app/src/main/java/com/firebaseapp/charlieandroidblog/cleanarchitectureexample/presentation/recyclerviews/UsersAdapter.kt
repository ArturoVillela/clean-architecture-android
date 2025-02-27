package com.firebaseapp.charlieandroidblog.cleanarchitectureexample.presentation.recyclerviews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.R
import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.data.User

class UsersAdapter (
val usersList:List<User>, val context: Context
) :RecyclerView.Adapter<UsersAdapter.UserViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.users_adapter_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(usersList.get(position))
    }


    inner class UserViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        fun bind(user: User){
            val tvUser1 = itemView.findViewById<TextView>(R.id.textView2)
            val tvUser2 = itemView.findViewById<TextView>(R.id.textView3)
            val tvUser3 = itemView.findViewById<TextView>(R.id.textView4)

            tvUser1.text = user.name
            tvUser2.text = user.phone
            tvUser3.text = user.address

        }
    }


}