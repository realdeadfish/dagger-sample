package com.example.daggersample

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.example.common.di.AndroidInjectorProvider
import com.example.common.di.DelegatingAndroidInjector
import com.example.daggersample.di.AppComponent
import dagger.android.AndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

internal class App : Application(), AndroidInjectorProvider, HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    override lateinit var activityInjector: AndroidInjector<Activity>
    @Inject
    override lateinit var fragmentInjector: AndroidInjector<Fragment>
    @Inject
    internal lateinit var delegatingAndroidInjector: DelegatingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        AppComponent.create(this).inject(this)
        delegatingAndroidInjector.registerInjectorProvider(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = delegatingAndroidInjector.activityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = delegatingAndroidInjector.fragmentInjector
}
