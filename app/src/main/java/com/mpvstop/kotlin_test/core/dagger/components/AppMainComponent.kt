package com.mpvstop.kotlin_test.core.dagger.components

import com.mpvstop.kotlin_test.core.app.App
import com.mpvstop.kotlin_test.core.dagger.builder.FragmentBuilder
import com.mpvstop.kotlin_test.core.dagger.modules.AppModule
import com.mpvstop.kotlin_test.core.dagger.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [(AndroidSupportInjectionModule::class),
        (AppModule::class),
        (NetworkModule::class),
        (FragmentBuilder::class)
    ]
)
interface AppMainComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {}
}

