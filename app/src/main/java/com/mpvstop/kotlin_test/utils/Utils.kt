package com.mpvstop.kotlin_test.utils

import android.content.Context
import android.util.Base64
import java.io.UnsupportedEncodingException
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

//        fun getJwtToken(): String? {
//            val claims = JwtClaims()
//
//            claims.setClaim(
//                "uid",
//                1
//            )
//
//            claims.setClaim(
//                "identity",
//                "abcd"
//            )
//            claims.jwtId = UUID.randomUUID().toString()
//            claims.setIssuedAtToNow()
//            claims.setExpirationTimeMinutesInTheFuture(60f)
//            val jws = JsonWebSignature()
//            jws.payload = claims.toJson()
//            val md: MessageDigest = MessageDigest.getInstance("SHA-256")
//            md.update(encodeString("\$SECRET$")?.toByteArray(charset("UTF-8")))
////            md.update("\$SECRET$".toByteArray(charset("UTF-8")))
//            val key: ByteArray = md.digest()
//            jws.key = HmacKey(key)
//
//            jws.setHeader("typ", "JWT");
//            jws.algorithmHeaderValue = AlgorithmIdentifiers.HMAC_SHA256
//
//            val jwt = jws.compactSerialization
//            println("JWT: $jwt")
//            return jwt
//        }

//        fun getJwtToken(): String? {
//            val currentTime = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
//            val expireTime = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
//            expireTime.add(Calendar.MINUTE, 60)
//
//            val jwt =
//                Jwts.builder().claim("uid", 1).claim("identity", "abcd")
//                    .claim("jti", UUID.randomUUID().toString())
//                    .claim("iat", currentTime.timeInMillis).claim("exp", expireTime.timeInMillis)
//                    .setHeaderParam("typ", "JWT")
//                    .signWith(SignatureAlgorithm.HS256, encodeString("\$SECRET$"))
//                    .compact()
//            Log.v("JWT : - ", jwt)
//            return jwt
//        }

        private fun encodeString(s: String): String? {
            var data = ByteArray(0)
            try {
                data = s.toByteArray(charset("UTF-8"))
            } catch (e: UnsupportedEncodingException) {
                e.printStackTrace()
            } finally {
                return Base64.encodeToString(data, Base64.NO_WRAP)
            }
        }
    }

}