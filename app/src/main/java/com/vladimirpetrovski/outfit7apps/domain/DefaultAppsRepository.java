package com.vladimirpetrovski.outfit7apps.domain;

import com.vladimirpetrovski.outfit7apps.data.App;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DefaultAppsRepository implements AppsRepository {

  @Inject
  DefaultAppsRepository() {
  }

  @Override
  public List<App> getInstalledApps() {
    //TODO implement
    return null;
  }
}
