package com.dalvinlabs.androidtestswithdagger

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MyApplication : Application(), HasActivityInjector {

  @Inject lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

  override fun onCreate() {
    super.onCreate()
    DaggerMyComponent.builder().build().inject(this)
  }

  override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector
}