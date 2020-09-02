package com.mpvstop.kotlin_test.ui.userfragment

import androidx.lifecycle.ViewModel
import com.mpvstop.kotlin_test.ui.userfragment.UserRepositry
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepsitry: UserRepositry) : ViewModel() {
    fun getUsers() = userRepsitry.getUsers();
}