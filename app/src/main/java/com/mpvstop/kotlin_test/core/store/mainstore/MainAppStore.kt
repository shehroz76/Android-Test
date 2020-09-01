package com.mpvstop.kotlin_test.core.store.mainstore

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import com.mpvstop.kotlin_test.core.store.offline.OfflineStore
import com.mpvstop.kotlin_test.core.store.online.OnlineStore
import javax.inject.Inject

class MainAppStore
@Inject constructor(
    val onlineStore: OnlineStore,
    val offlineStore: OfflineStore
) {


    fun setFirstTimeLaunch() {
        offlineStore.setFirstTimeLaunch()
    }

    fun isFirstTimeLaunch(): Boolean {
        return offlineStore.isFirstTimeLaunch()
    }

    fun isLoggedIn(): Boolean {
        return offlineStore.isLoggedIn()
    }

    fun setLoggedIn(loggedIn: Boolean) {
        offlineStore.setLoggedIn(loggedIn)
    }

}