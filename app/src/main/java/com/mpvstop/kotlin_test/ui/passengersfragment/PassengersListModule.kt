package com.mpvstop.kotlin_test.ui.passengersfragment

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.mpvstop.kotlin_test.core.store.online.ApiService
import com.mpvstop.kotlin_test.utils.AppExecutors
import com.mpvstop.kotlin_test.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class PassengersListModule {

    @Provides
    fun provideViewModel(userRepositry: PassengersRepositry): PassengersViewModel {
        return PassengersViewModel(
            userRepositry
        )
    }

    @Provides
    fun provideUserRepositry(apiService: ApiService, appExecutors: AppExecutors): PassengersRepositry {
        return PassengersRepositry(
            apiService,
            appExecutors
        )
    }

    @Provides
    fun provideViewModelProvider(viewModel: PassengersViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(viewModel)
    }

    @Provides
    fun provideAdapter(context: Context): PassengersAdapater {
        return PassengersAdapater(context)
    }
}
