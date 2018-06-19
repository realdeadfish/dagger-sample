package com.example.featurea.greeter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.featurea.R
import com.example.featureb.intent.FeatureBIntent
import com.example.featureb.intent.FeatureBIntentFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

internal class GreetingAActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var greeterA: GreeterA

    @Inject
    lateinit var featureBIntentFactory: FeatureBIntentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting_a)

        findViewById<TextView>(R.id.greeting_a).text = greeterA.greet()

        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(featureBIntentFactory.createIntent(FeatureBIntent.GreetingB))
        }
    }
}
