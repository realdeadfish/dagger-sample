package com.example.featureb

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import com.example.common.di.AndroidInjectorProvider
import com.example.common.di.DelegatingAndroidInjector
import com.example.common.di.DependencyProvider
import com.example.featureb.di.FeatureBComponent
import com.example.featureb.intent.FeatureBIntentFactory
import dagger.android.AndroidInjector
import javax.inject.Inject

class FeatureBProvider(configuration: Configuration) : DependencyProvider, AndroidInjectorProvider {
    @Inject
    override lateinit var activityInjector: AndroidInjector<Activity>
    @Inject
    override lateinit var fragmentInjector: AndroidInjector<Fragment>
    @Inject
    internal lateinit var delegatingAndroidInjector: DelegatingAndroidInjector

    val daggerComponent: FeatureBComponent by lazy {
        FeatureBComponent.create(configuration).also {
            it.inject(this@FeatureBProvider)
            delegatingAndroidInjector.registerInjectorProvider(this)
        }
    }

    fun provideIntentFactory(): FeatureBIntentFactory = daggerComponent.intentFactory.get()

    data class Configuration(val context: Context)

    object Factory : DependencyProvider.Factory<Configuration, FeatureBProvider>() {
        override fun create(configuration: Configuration) = FeatureBProvider(configuration)
    }
}
