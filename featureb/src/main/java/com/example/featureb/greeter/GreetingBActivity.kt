package com.example.featureb.greeter

import android.os.Bundle
import android.widget.TextView
import com.example.featureb.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

internal class GreetingBActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var greeterB: GreeterB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting_b)

        findViewById<TextView>(R.id.greeting_b).text = greeterB.greet()
    }
}
