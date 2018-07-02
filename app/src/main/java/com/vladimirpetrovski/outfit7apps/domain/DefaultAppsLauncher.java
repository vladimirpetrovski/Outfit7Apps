package com.vladimirpetrovski.outfit7apps.domain;

import android.content.Context;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DefaultAppsLauncher implements AppsLauncher {

  @Inject
  DefaultAppsLauncher(Context context) {
  }

  public void launchPackage(String packageName) {
    //TODO implement
  }
}
