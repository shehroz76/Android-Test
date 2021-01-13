package com.mpvstop.kotlin_test.utils

import android.content.Context
import android.util.Base64
import android.util.Log
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.io.UnsupportedEncodingException
import java.util.*
import javax.inject.Inject


class Utils @Inject constructor(val context: Context) {

    companion object {
        fun getErrorMessage(errorCode: Int): String {
            when (errorCode) {
                400 -> return "Bad Request"
                401 -> return "UnAuthorized"
                403 -> return "Forbidden"
                404 -> return "Not Found"
                500 -> return "Server Error"
                else -> return "network error"
            }
        }
    }

}