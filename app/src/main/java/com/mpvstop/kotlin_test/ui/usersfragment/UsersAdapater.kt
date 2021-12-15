package com.mpvstop.kotlin_test.ui.usersfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.mpvstop.kotlin_test.NavigationGraphDirections
import com.mpvstop.kotlin_test.R
import com.mpvstop.kotlin_test.ui.usersfragment.models.ResultsItem
import kotlinx.android.synthetic.main.adp_passenger_item.view.*
import javax.inject.Inject

class UsersAdapater @Inject
constructor(
    private val context: Context
) : RecyclerView.Adapter<UsersAdapater.CategoryViewHolder>() {
    private var userList = ArrayList<ResultsItem>()
    private var layoutInflater: LayoutInflater? = null

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): CategoryViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val view = layoutInflater!!.inflate(R.layout.adp_passenger_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindForecast(userList.get(position))
    }

    override fun getItemCount(): Int {
        return userList!!.size
    }

    fun setUserList(userList: List<ResultsItem?>) {
        this.userList = userList as ArrayList<ResultsItem>
        notifyDataSetChanged()
    }


    inner class CategoryViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        init {
            itemView.setOnClickListener {
                userList?.get(adapterPosition).name?.first.let { it1 ->
                    it1?.let { it2 ->
                        NavigationGraphDirections.actionPassengerDetailFragment(
                            it2
                        )
                    }
                }?.let { it2 ->
                    Navigation.findNavController(itemView)
                        .navigate(
                            it2
                        )
                }
            }
        }

        fun bindForecast(data: ResultsItem) {
            itemView.user_name.text = "${data?.name?.first} ${data?.name?.last}"
        }
    }


}