package com.mpvstop.kotlin_test.core.app

import com.mpvstop.kotlin_test.core.dagger.components.DaggerAppMainComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    companion object {
        private var instance: App? = null

        @Synchronized
        fun getInstance(): App? {
            return instance
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppMainComponent.builder().create(this)


    override fun onCreate() {
        super.onCreate()
        instance = this
    }


}
