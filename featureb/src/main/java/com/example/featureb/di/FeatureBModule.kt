package com.example.featureb.di

import com.example.common.di.ActivityScope
import com.example.featureb.greeter.GreetingBActivity
import com.example.featureb.greeter.GreetingBFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [FeatureBModule.BindingModule::class])
internal class FeatureBModule {

    @Module
    interface BindingModule {
        @ContributesAndroidInjector
        @ActivityScope
        fun greetingBActivity(): GreetingBActivity

        @ContributesAndroidInjector
        @ActivityScope
        fun greetingBFragment(): GreetingBFragment
    }
}
