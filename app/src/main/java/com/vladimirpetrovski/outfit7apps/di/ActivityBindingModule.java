package com.vladimirpetrovski.outfit7apps.di;

import com.vladimirpetrovski.outfit7apps.presenter.main.MainActivity;
import com.vladimirpetrovski.outfit7apps.presenter.main.MainModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBindingModule {

  @ContributesAndroidInjector(modules = MainModule.class)
  abstract MainActivity configureMainActivityInjection();
}
