package com.mpvstop.kotlin_test.ui.passengersfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.mpvstop.kotlin_test.NavigationGraphDirections
import com.mpvstop.kotlin_test.R
import com.mpvstop.kotlin_test.ui.passengersfragment.models.PassengerItem
import kotlinx.android.synthetic.main.adp_passenger_item.view.*
import javax.inject.Inject

class PassengersAdapater @Inject
constructor(
    private val context: Context
) : RecyclerView.Adapter<PassengersAdapater.CategoryViewHolder>() {
    private var userList = ArrayList<PassengerItem>()
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

    fun setUserList(userList: List<PassengerItem?>) {
        this.userList = userList as ArrayList<PassengerItem>
        notifyDataSetChanged()
    }


    inner class CategoryViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        init {
            itemView.setOnClickListener {
//                Navigation.findNavController(itemView)
//                    .navigate(
//                        NavigationGraphDirections.actionUserDetailFragment(
//                            userList?.get(adapterPosition)
//                        )
//                    )
                userList?.get(adapterPosition)._id?.let { it1 ->
                    NavigationGraphDirections.actionPassengerDetailFragment(
                        it1
                    )
                }?.let { it2 ->
                    Navigation.findNavController(itemView)
                        .navigate(
                            it2
                        )
                }
            }
        }

        fun bindForecast(data: PassengerItem?) {
            itemView.user_name.text = data?.name
        }
    }


}