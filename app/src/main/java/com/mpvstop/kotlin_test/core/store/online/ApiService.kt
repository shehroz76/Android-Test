package com.mpvstop.kotlin_test.core.store.online

import androidx.lifecycle.LiveData
import com.mpvstop.kotlin_test.ui.usersfragment.models.UsersResponse
import com.mpvstop.kotlin_test.utils.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/")
    fun getPassngers(@Query("results") page:Int): LiveData<ApiResponse<UsersResponse>>

}
