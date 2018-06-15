package com.dalvinlabs.mylibrary

import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject

class TestActivity : AppCompatActivity(), HasFragmentInjector {

  @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    fragmentManager.beginTransaction()
        .add(android.R.id.content, LibraryFragment.newInstance(), "LibraryFragment")
        .commit()
  }

  override fun fragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector
}
