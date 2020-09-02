package com.mpvstop.kotlin_test.core.dagger.builder

import com.mpvstop.kotlin_test.ui.activities.MainActivity
import com.mpvstop.kotlin_test.ui.userdetailfragment.UserDetailFragment
import com.mpvstop.kotlin_test.ui.userdetailfragment.UserDetailModule
import com.mpvstop.kotlin_test.ui.userfragment.UserListModule
import com.mpvstop.kotlin_test.ui.userfragment.UsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [UserListModule::class])
    abstract fun provideUsersFragment(): UsersFragment

    @ContributesAndroidInjector(modules = [UserDetailModule::class])
    abstract fun provideUserDetailFragment(): UserDetailFragment

    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

}