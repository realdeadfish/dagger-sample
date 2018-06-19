package com.example.common.di

import android.app.Activity
import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector

@Module
interface AndroidInjectorModule {
    @Binds
    fun androidActivityInjector(injector: DispatchingAndroidInjector<Activity>): AndroidInjector<Activity>

    @Binds
    fun androidFragmentInjector(injector: DispatchingAndroidInjector<Fragment>): AndroidInjector<Fragment>
}
