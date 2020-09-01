package com.mpvstop.kotlin_test.core.dagger.modules

import android.text.TextUtils
import com.mpvstop.kotlin_test.BuildConfig
import com.mpvstop.kotlin_test.core.store.online.ApiService
import com.mpvstop.kotlin_test.utils.Constants
import com.mpvstop.kotlin_test.utils.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    private val REQUEST_TIMEOUT = 10
    private lateinit var okHttpClient: OkHttpClient

    @Singleton
    @Provides
    internal fun providesClient(): OkHttpClient {
        lateinit var httpClient: OkHttpClient
//            val token = BaseActivity.getToken()
//        val token = App.getToken()
        val token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjEsImlkZW50aXR5IjoiYWJjIiwianRpIjoiYTc4ZTE4YWYtOTJkYy00ZWY5LWIzMDMtOTBkZTA0NGIyYmRiIiwiaWF0IjoxNTk4OTc4NDEwLCJleHAiOjE1OTg5ODIwMTB9.Vt821o7kzsrnRARv7Huxxg72PlXNhVU8Iyuwaj7FW8E"
        var finalToken = ""

        if (!TextUtils.isEmpty(token)) {
            finalToken = "Bearer $token"
        }
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY


        val interceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .header("Authorization", finalToken)
                .header("accept", "application/json")
                .build()

            chain.proceed(request)
        }
        val httpClientBuilder = OkHttpClient.Builder()
            .connectTimeout((500 * 1000).toLong(), TimeUnit.SECONDS)
            .writeTimeout((500 * 1000).toLong(), TimeUnit.SECONDS)
            .readTimeout((500 * 1000).toLong(), TimeUnit.SECONDS)
        httpClientBuilder.addInterceptor(interceptor)
        httpClientBuilder.addInterceptor(logging)

        if (BuildConfig.DEBUG) {

//                val logging = HttpLoggingInterceptor()
//                logging.level = HttpLoggingInterceptor.Level.BODY
//                httpClientBuilder.addInterceptor(logging)
//            LogUtil.e("BaseHttp", "interceptor added")
        }
        httpClient = httpClientBuilder.build()
        return httpClient
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

//        for call with live-data-adater
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(providesClient())
            .build()


    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}