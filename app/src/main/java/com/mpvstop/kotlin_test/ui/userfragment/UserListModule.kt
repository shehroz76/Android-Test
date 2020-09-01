package com.mpvstop.kotlin_test.ui.userfragment

import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.mpvstop.kotlin_test.core.dbase.UserDao
import com.mpvstop.kotlin_test.core.store.online.ApiService
import com.mpvstop.kotlin_test.utils.AppExecutors
import com.mpvstop.kotlin_test.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import java.util.ArrayList

@Module
class UserListModule {
    internal var listener: View.OnClickListener? = null

    @Provides
    fun provideViewModel(context: Context, userRepositry: UserRepositry): UserViewModel {
        return UserViewModel(
            userRepositry
        )
    }

    @Provides
    fun provideUserRepositry(context: Context, apiService: ApiService, appExecutors: AppExecutors): UserRepositry {
        return UserRepositry(
            context,
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
