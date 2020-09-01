package com.mpvstop.kotlin_test.core.store.offline

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.mpvstop.kotlin_test.core.managers.PrefManagers
import javax.inject.Inject

class OfflineStore @Inject constructor(val prefManager: PrefManagers) {

    fun setFirstTimeLaunch() {
        prefManager.setFirstTimeLaunch(false)
    }

    fun isFirstTimeLaunch(): Boolean {
        return prefManager.isFirstTimeLaunch()
    }

    fun isLoggedIn(): Boolean {
        return prefManager.isLoggedIn()
    }

    fun setLoggedIn(loggedIn: Boolean) {
        prefManager.setLoggedIn(loggedIn)
    }
}