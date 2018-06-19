package com.example.common.di

import android.app.Activity
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector

class DelegatingAndroidInjector : AndroidInjectorProvider {

    private val providers = mutableSetOf<AndroidInjectorProvider>()

    fun registerInjectorProvider(provider: AndroidInjectorProvider) = this.also { providers.add(provider) }

    override val activityInjector: AndroidInjector<Activity>
        get() = AndroidInjector { instance ->
            providers.find { injectorProvider ->
                try {
                    injectorProvider.activityInjector.inject(instance)
                    true
                } catch (e: IllegalArgumentException) {
                    false
                }
            } ?: throw  IllegalArgumentException("No injector found to inject $instance")
        }

    override val fragmentInjector: AndroidInjector<Fragment>
        get() = AndroidInjector { instance ->
            providers.find { injectorProvider ->
                try {
                    injectorProvider.fragmentInjector.inject(instance)
                    true
                } catch (e: IllegalArgumentException) {
                    false
                }
            } ?: throw  IllegalArgumentException("No injector found to inject $instance")
        }

    companion object {
        val instance = DelegatingAndroidInjector()
    }
}
