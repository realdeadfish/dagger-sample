package com.example.featurea.di

import android.content.Context
import com.example.common.di.AndroidInjectorModule
import com.example.common.di.CommonComponent
import com.example.common.di.commonComponent
import com.example.featurea.FeatureAProvider
import com.example.featurea.intent.FeatureAIntentFactory
import com.example.featureb.FeatureBProvider
import com.example.featureb.di.FeatureBComponent
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectorModule::class,
        FeatureAModule::class
    ],
    dependencies = [
        CommonComponent::class,
        FeatureBComponent::class
    ]
)
interface FeatureAComponent {
    companion object {
        fun create(configuration: FeatureAProvider.Configuration) =
            DaggerFeatureAComponent.builder()
                .configuration(configuration)
                .commonComponent(configuration.context.commonComponent)
                .featureBComponent(getFeatureBComponent(configuration.context))
                .build()

        private fun getFeatureBComponent(context: Context): FeatureBComponent =
            FeatureBProvider.Factory.get(FeatureBProvider.Configuration(context)).daggerComponent
    }

    fun inject(featureAProvider: FeatureAProvider)

    val intentFactory: dagger.Lazy<FeatureAIntentFactory>

    @Component.Builder
    interface FeatureAComponentBuilder {
        @BindsInstance
        fun configuration(configuration: FeatureAProvider.Configuration): FeatureAComponentBuilder

        fun commonComponent(commonComponent: CommonComponent): FeatureAComponentBuilder

        fun featureBComponent(featureBComponent: FeatureBComponent): FeatureAComponentBuilder

        fun build(): FeatureAComponent
    }
}
