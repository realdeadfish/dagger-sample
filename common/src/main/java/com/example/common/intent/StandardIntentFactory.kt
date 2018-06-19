package com.example.common.intent

import android.content.Context
import android.content.Intent

open class StandardIntentFactory<T : IntentInfo>(private val context: Context) : IntentFactory<T> {
    override fun createIntent(info: T): Intent = Intent().apply {
        setClassName(context.packageName, info.component)
        putExtras(info.extras)
    }
}
