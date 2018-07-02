package com.vladimirpetrovski.outfit7apps.di;

import android.app.Application;
import android.content.Context;
import com.vladimirpetrovski.outfit7apps.domain.AppsRepository;
import com.vladimirpetrovski.outfit7apps.domain.DefaultAppsRepository;
import com.vladimirpetrovski.outfit7apps.domain.AppsLauncher;
import com.vladimirpetrovski.outfit7apps.domain.DefaultAppsLauncher;
import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;

@Module
abstract class AppModule {

  @Binds
  abstract Context bindContext(Application application);

  @Singleton
  @Binds
  abstract AppsRepository bindAppsRepository(DefaultAppsRepository provider);

  @Singleton
  @Binds
  abstract AppsLauncher bindAppsLauncher(DefaultAppsLauncher appsLauncher);
}
