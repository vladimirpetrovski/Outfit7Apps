package com.vladimirpetrovski.outfit7apps.domain;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
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
        ApplicationInfo ai;
        try {
          ai = packageManager.getApplicationInfo(info.packageName, PackageManager.GET_META_DATA);
        } catch (final NameNotFoundException e) {
          ai = null;
        }
        final String applicationName =
            ai != null ? (String) packageManager.getApplicationLabel(ai) : "(unknown)";
        outfit7Apps
            .add(new App(info.packageName, applicationName, info.versionCode, info.versionName));
      }
    }
    return outfit7Apps;
  }
}
