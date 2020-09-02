package com.mpvstop.kotlin_test.core.store.online

import androidx.lifecycle.LiveData
import com.mpvstop.kotlin_test.ui.userdetailfragment.models.UserDetail
import com.mpvstop.kotlin_test.ui.userfragment.models.Users
import com.mpvstop.kotlin_test.utils.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("list")
    fun getUsers(): LiveData<ApiResponse<Users>>

    @GET("/get/{id}")
    fun getUser(@Path("id") apikey: String): LiveData<ApiResponse<UserDetail>>

}
