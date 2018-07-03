package com.example.featurea.di

import com.example.common.di.ActivityScope
import com.example.featurea.greeter.GreetingAActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [FeatureAModule.BindingModule::class])
internal class FeatureAModule {

    @Module
    interface BindingModule {
        @ContributesAndroidInjector(modules = [GreetingAModule::class])
        @ActivityScope
        fun greetingAActivity(): GreetingAActivity
    }
}
