package com.example.daggersample.di

import android.content.Context
import com.example.common.di.AndroidInjectorModule
import com.example.common.di.CommonComponent
import com.example.common.di.commonComponent
import com.example.daggersample.App
import com.example.featurea.FeatureAProvider
import com.example.featurea.di.FeatureAComponent
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectorModule::class,
        AppModule::class
    ],
    dependencies = [
        CommonComponent::class,
        FeatureAComponent::class
    ]
)
internal interface AppComponent {

    fun inject(app: App)

    companion object {
        fun create(context: Context) =
            DaggerAppComponent.builder()
                .commonComponent(context.commonComponent)
                .featureAComponent(buildFeatureAComponent(context))
                .build()

        private fun buildFeatureAComponent(context: Context): FeatureAComponent =
            FeatureAProvider.Factory.get(FeatureAProvider.Configuration(context)).daggerComponent
    }

    @Component.Builder
    interface AppComponentBuilder {

        fun commonComponent(commonComponent: CommonComponent): AppComponentBuilder

        fun featureAComponent(featureAComponent: FeatureAComponent): AppComponentBuilder

        fun build(): AppComponent
    }
}
