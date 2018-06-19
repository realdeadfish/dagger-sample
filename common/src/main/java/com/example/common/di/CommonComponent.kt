package com.example.common.di

import android.content.Context
import com.example.common.CommonProvider
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        CommonModule::class
    ]
)
interface CommonComponent {

    fun inject(commonProvider: CommonProvider)

    val context: Context

    val delegatingAndroidInjector: DelegatingAndroidInjector

    @Component.Builder
    interface CommonUiComponentBuilder {
        @BindsInstance
        fun context(context: Context): CommonUiComponentBuilder

        fun build(): CommonComponent
    }

    companion object {
        fun create(commonConfiguration: CommonProvider.Configuration) =
            DaggerCommonComponent.builder()
                .context(commonConfiguration.context)
                .build()
    }
}

val Context.commonComponent: CommonComponent
    get() = CommonProvider.Factory.get(CommonProvider.Configuration(this)).daggerComponent
