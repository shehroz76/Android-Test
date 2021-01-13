package com.mpvstop.kotlin_test.core.dagger.builder

import com.mpvstop.kotlin_test.ui.activities.MainActivity
import com.mpvstop.kotlin_test.ui.passengerdetailfragment.PassengersDetailFragment
import com.mpvstop.kotlin_test.ui.passengerdetailfragment.PassengerDetailModule
import com.mpvstop.kotlin_test.ui.passengersfragment.PassengersListModule
import com.mpvstop.kotlin_test.ui.passengersfragment.PassengersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [PassengersListModule::class])
    abstract fun providePassengersFragment(): PassengersFragment

    @ContributesAndroidInjector(modules = [PassengerDetailModule::class])
    abstract fun providePassengersDetailFragment(): PassengersDetailFragment

    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

}