package com.mpvstop.kotlin_test.ui.userdetailfragment

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class UserDetailViewModel @Inject constructor(private val userDetailRepositry: UserDetailRepositry) :
    ViewModel() {
//    fun getPassengerById(id: String) = userDetailRepositry.getPassengerById(id)
}
