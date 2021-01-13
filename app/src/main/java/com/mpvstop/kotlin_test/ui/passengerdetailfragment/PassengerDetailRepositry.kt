package com.mpvstop.kotlin_test.ui.passengerdetailfragment

import androidx.lifecycle.LiveData
import com.kotlinmvvm.app.utils.NetworkBoundResource
import com.mpvstop.kotlin_test.core.store.online.ApiService
import com.mpvstop.kotlin_test.ui.passengersfragment.models.PassengerItem
import com.mpvstop.kotlin_test.utils.ApiResponse
import com.mpvstop.kotlin_test.utils.AppExecutors
import com.mpvstop.kotlin_test.utils.Resource
import javax.inject.Inject

class PassengerDetailRepositry @Inject constructor(
    private val apiService: ApiService,
    private val appExecutors: AppExecutors
) {

    fun getPassengerById(id: String): LiveData<Resource<PassengerItem>> {
        return object : NetworkBoundResource<PassengerItem>(appExecutors) {

            override fun createCall(): LiveData<ApiResponse<PassengerItem>> = apiService.getPassengerById(id)

        }.asLiveData()
    }

}