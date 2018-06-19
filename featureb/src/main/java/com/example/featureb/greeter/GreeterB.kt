package com.example.featureb.greeter

import javax.inject.Inject

class GreeterB @Inject constructor() {
    fun greet(): String = "Hello world from B!"
}
