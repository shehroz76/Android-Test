package com.mpvstop.kotlin_test.ui.usersfragment

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.mpvstop.kotlin_test.core.store.online.ApiService
import com.mpvstop.kotlin_test.utils.AppExecutors
import com.mpvstop.kotlin_test.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class UsersListModule {

    @Provides
    fun provideViewModel(userRepositry: UsersRepositry): UsersViewModel {
        return UsersViewModel(
            userRepositry
        )
    }

    @Provides
    fun provideUserRepositry(apiService: ApiService, appExecutors: AppExecutors): UsersRepositry {
        return UsersRepositry(
            apiService,
            appExecutors
        )
    }

    @Provides
    fun provideViewModelProvider(viewModel: UsersViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(viewModel)
    }

    @Provides
    fun provideAdapter(context: Context): UsersAdapater {
        return UsersAdapater(context)
    }
}
