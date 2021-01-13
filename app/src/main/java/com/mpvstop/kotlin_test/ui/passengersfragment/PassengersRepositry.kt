package com.mpvstop.kotlin_test.ui.passengersfragment

import androidx.lifecycle.LiveData
import com.kotlinmvvm.app.utils.NetworkBoundResource
import com.mpvstop.kotlin_test.core.store.online.ApiService
import com.mpvstop.kotlin_test.ui.passengersfragment.models.PassengersResonse
import com.mpvstop.kotlin_test.utils.ApiResponse
import com.mpvstop.kotlin_test.utils.AppExecutors
import com.mpvstop.kotlin_test.utils.Resource
import javax.inject.Inject

class PassengersRepositry @Inject constructor(
    private val apiService: ApiService,
    private val appExecutors: AppExecutors
) {

    fun getPassngers(): LiveData<Resource<PassengersResonse>> {
        return object : NetworkBoundResource<PassengersResonse>(appExecutors) {

            override fun createCall(): LiveData<ApiResponse<PassengersResonse>> = apiService.getPassngers(1,10)

        }.asLiveData()
    }

}