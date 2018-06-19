package com.example.common.di

interface DependencyProvider {
    abstract class Factory<in C, out I> {
        private val instances = mutableMapOf<C, I>()

        fun get(configuration: C) = instances.getOrPut(configuration, { create(configuration) })

        protected abstract fun create(configuration: C): I
    }
}
