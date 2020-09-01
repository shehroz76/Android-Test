package com.mpvstop.kotlin_test.ui.userdetailfragment

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.mpvstop.kotlin_test.core.store.online.ApiService
import com.mpvstop.kotlin_test.utils.AppExecutors
import com.mpvstop.kotlin_test.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import java.util.ArrayList

@Module
class UserDetailModule {

    @Provides
    fun provideViewModel(
        context: Context,
        userDetailRepositry: UserDetailRepositry
    ): UserDetailViewModel {
        return UserDetailViewModel(
            userDetailRepositry
        )
    }

    @Provides
    fun provideUserRepositry(
        context: Context,
        apiService: ApiService,
        appExecutors: AppExecutors
    ): UserDetailRepositry {
        return UserDetailRepositry(
            context,
            apiService,
            appExecutors
        )
    }

    @Provides
    fun provideViewModelProvider(viewModel: UserDetailViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(viewModel)
    }

}
