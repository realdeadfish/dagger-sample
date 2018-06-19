package com.example.common.di

import android.app.Activity
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector

interface AndroidInjectorProvider {
    val activityInjector: AndroidInjector<Activity>
    val fragmentInjector: AndroidInjector<Fragment>
}
