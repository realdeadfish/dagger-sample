package com.example.featureb.intent

import android.os.Bundle
import com.example.common.intent.IntentInfo
import com.example.featureb.greeter.GreetingBActivity

sealed class FeatureBIntent(
    override val component: String,
    override val extras: Bundle = Bundle()
) : IntentInfo {
    object GreetingB : FeatureBIntent(GreetingBActivity::class.java.name)
}
