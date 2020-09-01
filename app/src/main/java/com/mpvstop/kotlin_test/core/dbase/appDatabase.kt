package com.mpvstop.kotlin_test.core.dbase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mpvstop.kotlin_test.ui.userdetailfragment.models.UserDetail
import com.mpvstop.kotlin_test.ui.userfragment.models.Users

@Database(entities = [UserDetail::class, Users::class], version = 1)
abstract class appDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}
