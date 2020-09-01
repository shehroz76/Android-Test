package com.mpvstop.kotlin_test.ui.userdetailfragment

import androidx.lifecycle.ViewModel
import com.mpvstop.kotlin_test.ui.userfragment.UserRepositry
import javax.inject.Inject

class UserDetailViewModel @Inject constructor(private val userDetailRepositry: UserDetailRepositry) : ViewModel() {

    // by live-data adapter pattern
    fun getUsers(page: String) = userDetailRepositry.getUserDetail(page);

}