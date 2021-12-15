package com.mpvstop.kotlin_test.core.dbase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.mpvstop.kotlin_test.ui.usersfragment.models.UsersResponse


@Dao
interface PassengerDao {

    fun getAllPassengersData(): LiveData<UsersResponse>

//    fun getPassengerDetail(id:Int): LiveData<PassengerItem>

}
