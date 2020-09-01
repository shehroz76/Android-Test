package com.mpvstop.kotlin_test.ui.userfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mpvstop.kotlin_test.R
import kotlinx.android.synthetic.main.adp_user_item.view.*
import javax.inject.Inject

class UserAdapater @Inject
constructor(
    private val context: Context
) : RecyclerView.Adapter<UserAdapater.CategoryViewHolder>() {
    private var userList= ArrayList<String>()
    private var layoutInflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): CategoryViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val view = layoutInflater!!.inflate(R.layout.adp_user_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindForecast(userList.get(position))
    }

    override fun getItemCount(): Int {
        return userList!!.size
    }

    fun getUserList(): List<String?> {
        return userList
    }

    fun setUserList(userList: List<String?>) {
        this.userList = userList as ArrayList<String>
        notifyDataSetChanged()
    }


    inner class CategoryViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bindForecast(data: String?) {
            itemView.user_name.text = data
        }
    }


}