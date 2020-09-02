package com.mpvstop.kotlin_test.ui.userdetailfragment

import androidx.lifecycle.ViewModel
import com.mpvstop.kotlin_test.ui.userfragment.UserRepositry
import javax.inject.Inject

class UserDetailViewModel @Inject constructor(private val userDetailRepositry: UserDetailRepositry) : ViewModel() {

    fun getUserDetail(page: String) = userDetailRepositry.getUserDetail(page);

}