package com.example.common.di

import dagger.Module
import dagger.Provides

@Module(includes = [CommonModule.BinderModule::class, CommonModule.ProviderModule::class])
internal class CommonModule {

    @Module
    interface BinderModule {
        // all of our @Binds
    }

    @Module
    class ProviderModule {
        // No scoping here! Need to return always the same instance!
        @Provides
        fun provideDelegatingAndroidInjector() = DelegatingAndroidInjector.instance
    }
}
