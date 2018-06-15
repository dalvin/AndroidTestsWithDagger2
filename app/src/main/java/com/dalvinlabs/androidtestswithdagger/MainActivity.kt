package com.dalvinlabs.androidtestswithdagger

import android.app.Fragment
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.dalvinlabs.androidtestswithdagger.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasFragmentInjector {

  @Inject lateinit var appResource: AppResource
  @Inject lateinit var activityResource: ActivityResource
  @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    binding.appResource = appResource.name
    binding.activityResource = activityResource.name
    Log.d("MainActivity", "appResource =  $appResource.toString()")
    Log.d("MainActivity", "activityResource =  $activityResource.toString()")
  }

  override fun fragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector
}
