package com.example.android.room.view.main

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.room.R
import com.example.android.room.constants.Constants
import com.example.android.room.databinding.ItemLayoutBinding
import com.example.android.room.db.dao.UserDao
import com.example.android.room.model.User
import com.example.android.room.view.detail.DetailActivity
import org.koin.core.KoinComponent
import org.koin.core.inject

class UserListAdapter(private val context: Activity, private var userList: ArrayList<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), KoinComponent {

    private val userDao: UserDao by inject()

    fun setList(userList: ArrayList<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        val binding = ItemLayoutBinding.bind(itemView)
        return ItemViewHolder(binding, itemView)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder){
            holder.binding.viewTvTitle.text = userList[position].title
        }
    }

    inner class ItemViewHolder(
        val binding: ItemLayoutBinding,
        itemView: View
    ) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            binding.viewIvEdit.setOnClickListener(this)
            binding.viewIvDelete.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position: Int = adapterPosition
            val user: User? = userList[position]
            val intent = Intent(context, DetailActivity::class.java)
            if (user != null) {
                intent.putExtra(Constants.PARCEL, user)
            }
            if (p0?.id == R.id.view_iv_delete) {
                userList.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, itemCount)
                if (user != null) {
                    userDao.delete(user)
                }
            } else {
                context.startActivityForResult(intent, Constants.DETAIL)
            }
        }
    }
}