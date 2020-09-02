package com.mpvstop.kotlin_test.utils

class Constants {

    companion object {
        //Shared preferences
        val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
        val PREF_NAME = "HorizonCache"
        val CACHED_USER = "CachedUser"
        val LOGGED_IN = "LoggedIn"

        //Network
        val BASE_URL = "http://opn-interview-service.nn.r.appspot.com/"

        // hard-coded-jwt-token
        val Token =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjEsImlkZW50aXR5IjoiYWJjIiwianRpIjoiNzY3OTczMTMtYzY4Ni00NzNmLWEzMWItMzYxZTA0ZGQxYjhhIiwiaWF0IjoxNTk5MDU0MzgxLCJleHAiOjE1OTk5MTgzODF9.D5JuMF8-9UU544F1X_um4-TFeX-hIwsQpGq04VDD4OM"
//        val Token = getJwtToken() // generateJWtToken
    }

}