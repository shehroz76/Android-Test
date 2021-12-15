package com.mpvstop.kotlin_test.core.dagger.builder

import com.mpvstop.kotlin_test.ui.activities.MainActivity
import com.mpvstop.kotlin_test.ui.userdetailfragment.UsersDetailFragment
import com.mpvstop.kotlin_test.ui.userdetailfragment.UserDetailModule
import com.mpvstop.kotlin_test.ui.usersfragment.UsersListModule
import com.mpvstop.kotlin_test.ui.usersfragment.UsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [UsersListModule::class])
    abstract fun providePassengersFragment(): UsersFragment

    @ContributesAndroidInjector(modules = [UserDetailModule::class])
    abstract fun providePassengersDetailFragment(): UsersDetailFragment

    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

}