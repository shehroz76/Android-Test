package com.mpvstop.kotlin_test.ui.passengerdetailfragment

import androidx.lifecycle.ViewModelProvider
import com.mpvstop.kotlin_test.core.store.online.ApiService
import com.mpvstop.kotlin_test.utils.AppExecutors
import com.mpvstop.kotlin_test.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides

@Module
class PassengerDetailModule {

    @Provides
    fun provideViewModel(
        userDetailRepositry: PassengerDetailRepositry
    ): PassengerDetailViewModel {
        return PassengerDetailViewModel(
            userDetailRepositry
        )
    }

    @Provides
    fun provideUserRepositry(
        apiService: ApiService,
        appExecutors: AppExecutors
    ): PassengerDetailRepositry {
        return PassengerDetailRepositry(
            apiService,
            appExecutors
        )
    }

    @Provides
    fun provideViewModelProvider(viewModel: PassengerDetailViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(viewModel)
    }

}
