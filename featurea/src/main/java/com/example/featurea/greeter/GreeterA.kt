package com.example.featurea.greeter

import javax.inject.Inject

class GreeterA @Inject constructor() {
    fun greet(): String = "Hello world from A!"
}
