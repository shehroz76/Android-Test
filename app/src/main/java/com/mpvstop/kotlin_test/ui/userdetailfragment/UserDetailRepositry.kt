package com.mpvstop.kotlin_test.ui.userdetailfragment

import android.content.Context
import androidx.lifecycle.LiveData
import com.kotlinmvvm.app.utils.NetworkBoundResource
import com.mpvstop.kotlin_test.core.dbase.UserDao
import com.mpvstop.kotlin_test.core.store.online.ApiService
import com.mpvstop.kotlin_test.ui.userdetailfragment.models.UserDetail
import com.mpvstop.kotlin_test.utils.ApiResponse
import com.mpvstop.kotlin_test.utils.AppExecutors
import com.mpvstop.kotlin_test.utils.Resource
import javax.inject.Inject

class UserDetailRepositry @Inject constructor(
    private val context: Context, private val apiService: ApiService,
    private val appExecutors: AppExecutors
) {

    fun getUserDetail(page: String): LiveData<Resource<UserDetail>> {
        return object : NetworkBoundResource<UserDetail>(appExecutors) {

            override fun createCall(): LiveData<ApiResponse<UserDetail>> = apiService.getUser(page)

        }.asLiveData()
    }

}