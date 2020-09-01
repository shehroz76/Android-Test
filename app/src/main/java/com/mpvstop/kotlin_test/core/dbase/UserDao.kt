package com.mpvstop.kotlin_test.core.dbase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mpvstop.kotlin_test.ui.userdetailfragment.models.UserDetail
import com.mpvstop.kotlin_test.ui.userfragment.models.Users


@Dao
interface UserDao {

    fun getAllUsers(): LiveData<Users>

    fun getUserDetail(): LiveData<UserDetail>

}
