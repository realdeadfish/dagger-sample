package com.example.featurea

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import com.example.common.di.AndroidInjectorProvider
import com.example.common.di.DelegatingAndroidInjector
import com.example.common.di.DependencyProvider
import com.example.featurea.di.FeatureAComponent
import com.example.featurea.intent.FeatureAIntentFactory
import dagger.android.AndroidInjector
import javax.inject.Inject

class FeatureAProvider(configuration: Configuration) : DependencyProvider, AndroidInjectorProvider {
    @Inject
    override lateinit var activityInjector: AndroidInjector<Activity>
    @Inject
    override lateinit var fragmentInjector: AndroidInjector<Fragment>
    @Inject
    internal lateinit var delegatingAndroidInjector: DelegatingAndroidInjector

    val daggerComponent: FeatureAComponent by lazy {
        FeatureAComponent.create(configuration).also {
            it.inject(this@FeatureAProvider)
            delegatingAndroidInjector.registerInjectorProvider(this)
        }
    }

    fun provideIntentFactory(): FeatureAIntentFactory = daggerComponent.intentFactory.get()

    data class Configuration(val context: Context)

    object Factory : DependencyProvider.Factory<Configuration, FeatureAProvider>() {
        override fun create(configuration: Configuration) = FeatureAProvider(configuration)
    }
}
