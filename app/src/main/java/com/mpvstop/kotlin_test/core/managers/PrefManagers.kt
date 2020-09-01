package com.mpvstop.kotlin_test.core.managers

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.mpvstop.kotlin_test.utils.Constants
import javax.inject.Inject

class PrefManagers @Inject constructor(val context: Context, val gson: Gson) {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor


    init {
        sharedPreferences = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        editor.apply()
    }

    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        editor.putBoolean(Constants.IS_FIRST_TIME_LAUNCH, isFirstTime)
        editor.commit()
    }

    fun isFirstTimeLaunch(): Boolean {
        return sharedPreferences.getBoolean(Constants.IS_FIRST_TIME_LAUNCH, true)
    }


    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(Constants.LOGGED_IN, false)
    }

    fun setLoggedIn(isLoggedIn: Boolean) {
        editor.putBoolean(Constants.LOGGED_IN, isLoggedIn)
        editor.commit()
    }
}