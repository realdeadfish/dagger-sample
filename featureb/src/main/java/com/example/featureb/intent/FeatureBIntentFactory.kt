package com.example.featureb.intent

import android.content.Context
import com.example.common.intent.StandardIntentFactory
import javax.inject.Inject

class FeatureBIntentFactory @Inject constructor(context: Context) : StandardIntentFactory<FeatureBIntent>(context)
