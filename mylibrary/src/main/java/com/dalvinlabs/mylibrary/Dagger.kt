package com.dalvinlabs.mylibrary

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class LibraryModule {

  @ContributesAndroidInjector(modules = [LibraryFragmentModule::class])
  abstract fun contributesLibraryFragment(): LibraryFragment
}

@Module
class LibraryFragmentModule {
  @Provides
  fun providesLibraryResource() = LibraryResource()
}

data class LibraryResource(val name: String = "From Library Module: Production")