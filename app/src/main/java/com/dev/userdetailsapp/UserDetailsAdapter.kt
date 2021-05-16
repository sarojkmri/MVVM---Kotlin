package com.dev.userdetailsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dev.userdetailsapp.model.Users
import kotlinx.android.synthetic.main.user_detail_item.view.*


class UserDetailsAdapter(private val userDetailsList: ArrayList<Users>) :
    RecyclerView.Adapter<UserDetailsAdapter.DataViewHolder>() {

    class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(user: Users) {
            itemView.apply {
                name.text = user.name
                email.text = user.email
                phoneNumber.text = user.phone
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_detail_item, parent, false)
        )

    override fun getItemCount(): Int = userDetailsList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(userDetailsList[position])
    }


    fun addUserDetailsData(userList: List<Users>) {
        //sorted by name in alphabetical order
        val userList1 = userList.sortedWith(compareBy { it.name })
        userDetailsList.addAll(userList1)
        notifyDataSetChanged()
    }
}






