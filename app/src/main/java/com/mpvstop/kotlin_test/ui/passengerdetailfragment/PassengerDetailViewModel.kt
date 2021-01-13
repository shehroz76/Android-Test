package com.mpvstop.kotlin_test.ui.passengerdetailfragment

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class PassengerDetailViewModel @Inject constructor(private val userDetailRepositry: PassengerDetailRepositry) :
    ViewModel() {
    fun getPassengerById(id: String) = userDetailRepositry.getPassengerById(id)
}