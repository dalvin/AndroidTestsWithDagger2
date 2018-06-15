package com.dalvinlabs.mylibrary

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class TestApplication : Application(), HasActivityInjector {

  @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

  override fun onCreate() {
    DaggerTestComponent.builder().build().inject(this)
    super.onCreate()
  }

  override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

}