package com.mpvstop.kotlin_test.ui.passengersfragment.models

data class PassengersResonse(
    val totalPassengers: Int? = null,
    val data: List<PassengerItem?>? = null,
    val totalPages: Int? = null
)
