package com.mpvstop.kotlin_test.ui.usersfragment

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class UsersViewModel @Inject constructor(private val userRepsitry: UsersRepositry) : ViewModel() {
    fun getPassngers() = userRepsitry.getPassngers();
}