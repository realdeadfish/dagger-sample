package com.example.common.intent

import android.content.Intent

interface IntentFactory<in T : IntentInfo> {
    fun createIntent(info: T): Intent
}
