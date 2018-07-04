package com.vladimirpetrovski.outfit7apps.domain;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DefaultAppsLauncher implements AppsLauncher {

  private static final String TAG = DefaultAppsLauncher.class.getSimpleName();

  private Context context;

  @Inject
  DefaultAppsLauncher(Context context) {
    this.context = context;
  }

  public void launchPackage(String packageName) {
    try {
      Intent launchIntentForPackage =
          context.getPackageManager().getLaunchIntentForPackage(packageName);
      context.startActivity(launchIntentForPackage);
    } catch (Exception ex) {
      Log.e(TAG, ex.getMessage());
    }
  }
}
