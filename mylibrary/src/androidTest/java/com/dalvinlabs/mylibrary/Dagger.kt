package com.dalvinlabs.mylibrary

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Component(modules = [AndroidInjectionModule::class, ActivityContributor::class, LibraryFakeModule::class])
interface TestComponent{
  fun inject(application: TestApplication)
}

@Module
abstract class ActivityContributor {
  @ContributesAndroidInjector
  abstract fun contributeActivity(): TestActivity
}

@Module
abstract class LibraryFakeModule {

  @ContributesAndroidInjector(modules = [LibraryFakeFragmentModule::class])
  abstract fun contributesLibraryFragment(): LibraryFragment
}

@Module
class LibraryFakeFragmentModule {
  @Provides
  fun providesLibraryResource() = LibraryResource("From Library Module: FAKE")
}

