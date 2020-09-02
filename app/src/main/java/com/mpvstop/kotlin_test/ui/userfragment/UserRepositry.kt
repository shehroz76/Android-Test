package com.mpvstop.kotlin_test.ui.userfragment

import android.content.Context
import androidx.lifecycle.LiveData
import com.kotlinmvvm.app.utils.NetworkBoundResource
import com.mpvstop.kotlin_test.core.dbase.UserDao
import com.mpvstop.kotlin_test.core.store.online.ApiService
import com.mpvstop.kotlin_test.ui.userfragment.models.Users
import com.mpvstop.kotlin_test.utils.ApiResponse
import com.mpvstop.kotlin_test.utils.AppExecutors
import com.mpvstop.kotlin_test.utils.Resource
import javax.inject.Inject

class UserRepositry @Inject constructor(
    private val apiService: ApiService,
    private val appExecutors: AppExecutors
) {

    fun getUsers(): LiveData<Resource<Users>> {
        return object : NetworkBoundResource<Users>(appExecutors) {

            override fun createCall(): LiveData<ApiResponse<Users>> = apiService.getUsers()

        }.asLiveData()
    }

}