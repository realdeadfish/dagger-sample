package com.example.featurea.intent

import android.content.Context
import com.example.common.intent.StandardIntentFactory
import javax.inject.Inject

class FeatureAIntentFactory @Inject constructor(context: Context) : StandardIntentFactory<FeatureAIntent>(context)
