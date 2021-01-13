package com.mpvstop.kotlin_test.core.dbase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mpvstop.kotlin_test.ui.passengersfragment.models.PassengerItem
import com.mpvstop.kotlin_test.ui.passengersfragment.models.PassengersResonse

@Database(entities = [PassengerItem::class, PassengersResonse::class], version = 1)
abstract class appDatabase : RoomDatabase() {

    abstract fun passengerDao(): PassengerDao
}
