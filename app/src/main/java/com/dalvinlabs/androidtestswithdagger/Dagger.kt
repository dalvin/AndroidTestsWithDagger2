package com.dalvinlabs.androidtestswithdagger

import com.dalvinlabs.mylibrary.LibraryModule
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Component(modules = [AndroidInjectionModule::class,
  AppModule::class,
  ActivityContributor::class,
  LibraryModule::class])
interface MyComponent {
  fun inject(application: MyApplication)
}

@Module
class AppModule {
  @Provides fun providesAppResource(): AppResource = AppResource()
}

@Module
abstract class ActivityContributor {
  @ContributesAndroidInjector(modules = [MainActivityModule::class])
  abstract fun contributeActivity(): MainActivity
}

@Module
class MainActivityModule {
  @Provides fun providesMainActivityResource(): ActivityResource = ActivityResource()
}

data class AppResource(val name: String = "From App Module: Production")
data class ActivityResource(val name: String = "From Activity Module: Production")