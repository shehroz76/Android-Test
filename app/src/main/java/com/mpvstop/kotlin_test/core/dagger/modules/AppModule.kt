package com.mpvstop.kotlin_test.core.dagger.modules

import android.content.Context
import com.google.gson.Gson
import com.mpvstop.kotlin_test.core.app.App
import com.mpvstop.kotlin_test.core.store.mainstore.MainAppStore
import com.mpvstop.kotlin_test.core.store.offline.OfflineStore
import com.mpvstop.kotlin_test.core.store.online.OnlineStore
import com.mpvstop.kotlin_test.utils.Utils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: App): Context {
        return application
    }

    @Singleton
    @Provides
    fun provideMainAppStore(onlineStore: OnlineStore, offlineStore: OfflineStore): MainAppStore {
        return MainAppStore(onlineStore, offlineStore)

    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideUtils(context: Context): Utils {
        return Utils(context)
    }

//    @Singleton
//    @Provides
//    fun provideDb(app: Context): appDatabase {
//        return Room.databaseBuilder(
//            app,
//            appDatabase::class.java,
//            "kotlinTest.db"
//        ).fallbackToDestructiveMigration()
//            .build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideUserDao(db: appDatabase): UserDao {
//        return db.userDao()
//    }


}