package com.mpvstop.kotlin_test.core.dbase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mpvstop.kotlin_test.ui.usersfragment.models.UsersResponse

@Database(entities = [UsersResponse::class], version = 1)
abstract class appDatabase : RoomDatabase() {

    abstract fun passengerDao(): PassengerDao
}
