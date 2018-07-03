package com.example.featureb.greeter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.featureb.R
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class GreetingBFragment : DaggerFragment() {
    @Inject
    internal lateinit var greeter: GreeterB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_greeting_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.fragment_greeting_b).text = greeter.greet()
    }
}
