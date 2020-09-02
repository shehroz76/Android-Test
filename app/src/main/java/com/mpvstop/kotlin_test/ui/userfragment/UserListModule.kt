package com.mpvstop.kotlin_test.ui.userfragment

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.mpvstop.kotlin_test.core.store.online.ApiService
import com.mpvstop.kotlin_test.utils.AppExecutors
import com.mpvstop.kotlin_test.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class UserListModule {

    @Provides
    fun provideViewModel(userRepositry: UserRepositry): UserViewModel {
        return UserViewModel(
            userRepositry
        )
    }

    @Provides
    fun provideUserRepositry(apiService: ApiService, appExecutors: AppExecutors): UserRepositry {
        return UserRepositry(
            apiService,
            appExecutors
        )
    }

    @Provides
    fun provideViewModelProvider(viewModel: UserViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(viewModel)
    }

    @Provides
    fun provideAdapter(context: Context): UserAdapater {
        return UserAdapater(context)
    }
}
