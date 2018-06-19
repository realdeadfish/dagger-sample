package com.example.common.intent

import android.os.Bundle

/**
 * An interface that identifies data structures providing intent information
 */
interface IntentInfo {
    val component: String
    val extras: Bundle
}
