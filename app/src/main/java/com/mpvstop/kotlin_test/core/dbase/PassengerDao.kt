package com.mpvstop.kotlin_test.core.dbase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.mpvstop.kotlin_test.ui.passengersfragment.models.PassengerItem
import com.mpvstop.kotlin_test.ui.passengersfragment.models.PassengersResonse


@Dao
interface PassengerDao {

    fun getAllPassengersData(): LiveData<PassengersResonse>

    fun getPassengerDetail(id:Int): LiveData<PassengerItem>

}
