package com.example.featureb.di

import com.example.common.di.AndroidInjectorModule
import com.example.common.di.CommonComponent
import com.example.common.di.commonComponent
import com.example.featureb.FeatureBProvider
import com.example.featureb.intent.FeatureBIntentFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectorModule::class,
        FeatureBModule::class
    ],
    dependencies = [
        CommonComponent::class
    ]
)
interface FeatureBComponent {
    companion object {
        fun create(configuration: FeatureBProvider.Configuration) =
            DaggerFeatureBComponent.builder()
                .configuration(configuration)
                .commonComponent(configuration.context.commonComponent)
                .build()
    }

    fun inject(featureBProvider: FeatureBProvider)

    val intentFactory: dagger.Lazy<FeatureBIntentFactory>

    @Component.Builder
    interface FeatureBComponentBuilder {
        @BindsInstance
        fun configuration(configuration: FeatureBProvider.Configuration): FeatureBComponentBuilder

        fun commonComponent(commonComponent: CommonComponent): FeatureBComponentBuilder

        fun build(): FeatureBComponent
    }
}
