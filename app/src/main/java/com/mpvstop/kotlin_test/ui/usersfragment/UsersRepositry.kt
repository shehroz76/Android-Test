package com.mpvstop.kotlin_test.ui.usersfragment

import androidx.lifecycle.LiveData
import com.kotlinmvvm.app.utils.NetworkBoundResource
import com.mpvstop.kotlin_test.core.store.online.ApiService
import com.mpvstop.kotlin_test.ui.usersfragment.models.UsersResponse
import com.mpvstop.kotlin_test.utils.ApiResponse
import com.mpvstop.kotlin_test.utils.AppExecutors
import com.mpvstop.kotlin_test.utils.Resource
import javax.inject.Inject

class UsersRepositry @Inject constructor(
    private val apiService: ApiService,
    private val appExecutors: AppExecutors
) {

    fun getPassngers(): LiveData<Resource<UsersResponse>> {
        return object : NetworkBoundResource<UsersResponse>(appExecutors) {

            override fun createCall(): LiveData<ApiResponse<UsersResponse>> = apiService.getPassngers(200)

        }.asLiveData()
    }

}