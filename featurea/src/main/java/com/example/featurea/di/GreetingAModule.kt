package com.example.featurea.di

import com.example.common.di.FragmentScope
import com.example.featureb.greeter.GreetingBFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [GreetingAModule.BindingModule::class])
internal class GreetingAModule {
    @Module
    interface BindingModule {
        @ContributesAndroidInjector
        @FragmentScope
        fun greetingBFragment(): GreetingBFragment
    }
}
