package com.mpvstop.kotlin_test.core.store.online

import androidx.lifecycle.LiveData
import com.mpvstop.kotlin_test.ui.passengersfragment.models.PassengerItem
import com.mpvstop.kotlin_test.ui.passengersfragment.models.PassengersResonse
import com.mpvstop.kotlin_test.utils.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("passenger")
    fun getPassngers(@Query("page") page:Int,@Query("size") size:Int ): LiveData<ApiResponse<PassengersResonse>>

    @GET("passenger/{id}")
    fun getPassengerById(@Path("id") passengerId: String): LiveData<ApiResponse<PassengerItem>>

}
