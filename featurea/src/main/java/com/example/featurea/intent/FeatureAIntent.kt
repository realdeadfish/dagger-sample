package com.example.featurea.intent

import android.os.Bundle
import com.example.common.intent.IntentInfo
import com.example.featurea.greeter.GreetingAActivity

sealed class FeatureAIntent(
    override val component: String,
    override val extras: Bundle = Bundle()
) : IntentInfo {
    object GreetingA : FeatureAIntent(GreetingAActivity::class.java.name)
}
