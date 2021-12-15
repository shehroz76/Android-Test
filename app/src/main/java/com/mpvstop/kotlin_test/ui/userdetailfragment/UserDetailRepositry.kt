package com.mpvstop.kotlin_test.ui.userdetailfragment

import com.mpvstop.kotlin_test.core.store.online.ApiService
import com.mpvstop.kotlin_test.utils.AppExecutors
import javax.inject.Inject

class UserDetailRepositry @Inject constructor(
    private val apiService: ApiService,
    private val appExecutors: AppExecutors
) {

//    fun getPassengerById(id: String): LiveData<Resource<PassengerItem>> {
//        return object : NetworkBoundResource<PassengerItem>(appExecutors) {
//
//            override fun createCall(): LiveData<ApiResponse<PassengerItem>> = apiService.getPassengerById(id)
//
//        }.asLiveData()
//    }

}