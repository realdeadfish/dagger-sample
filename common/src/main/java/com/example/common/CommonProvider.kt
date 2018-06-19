package com.example.common

import android.content.Context
import com.example.common.di.CommonComponent
import com.example.common.di.DependencyProvider

// The provider acts as entry point for Dagger and non-Dagger consumers and is used at the same time as injection
// point for the Android injectors which we'll later delegate to
class CommonProvider(configuration: Configuration) : DependencyProvider {

    // expose the underlying Dagger component for easy usage in Dagger2 consumers
    val daggerComponent: CommonComponent by lazy {
        CommonComponent.create(configuration).also { it.inject(this@CommonProvider) }
    }

    // provide all things here for consumers that don't use Dagger2
    fun provideContext(): Context = daggerComponent.context

    data class Configuration(val context: Context)

    object Factory : DependencyProvider.Factory<Configuration, CommonProvider>() {
        override fun create(configuration: Configuration) = CommonProvider(configuration)
    }
}
