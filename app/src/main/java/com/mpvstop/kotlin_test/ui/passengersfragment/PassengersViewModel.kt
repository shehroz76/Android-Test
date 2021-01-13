package com.mpvstop.kotlin_test.ui.passengersfragment

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class PassengersViewModel @Inject constructor(private val userRepsitry: PassengersRepositry) : ViewModel() {
    fun getPassngers() = userRepsitry.getPassngers();
}