package com.vladimirpetrovski.outfit7apps.domain;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.vladimirpetrovski.outfit7apps.data.App;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DefaultAppsRepository implements AppsRepository {

  private static final String TAG = AppsRepository.class.getSimpleName();

  private Context context;

  @Inject
  DefaultAppsRepository(Context context) {
    this.context = context;
  }

  @Override
  public List<App> getInstalledApps() {
    PackageManager packageManager = context.getPackageManager();
    List<PackageInfo> installedPackages = packageManager
        .getInstalledPackages(PackageManager.GET_CONFIGURATIONS);
    List<App> outfit7Apps = new ArrayList<>();
    for (PackageInfo info : installedPackages) {
      if (info.packageName.startsWith("com.outfit7.")) {
        String applicationName = getPackageName(packageManager, info);
        outfit7Apps
            .add(new App(info.packageName, applicationName, info.versionCode, info.versionName));
      }
    }
    return outfit7Apps;
  }

  @Override
  public App getApp(String packageName) {
    PackageManager packageManager = context.getPackageManager();

    try {
      PackageInfo packageInfo = packageManager
          .getPackageInfo(packageName, PackageManager.GET_META_DATA);
      String applicationName = getPackageName(packageManager, packageInfo);
      return new App(packageInfo.packageName, applicationName, packageInfo.versionCode,
          packageInfo.versionName);
    } catch (NameNotFoundException e) {
      Log.e(TAG, e.getMessage());
    }
    return null;
  }


  private String getPackageName(PackageManager packageManager, PackageInfo info) {
    ApplicationInfo ai;
    try {
      ai = packageManager.getApplicationInfo(info.packageName, PackageManager.GET_META_DATA);
    } catch (final NameNotFoundException e) {
      ai = null;
    }
    return ai != null ? (String) packageManager.getApplicationLabel(ai) : "(unknown)";
  }
}
