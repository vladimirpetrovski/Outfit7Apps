package com.vladimirpetrovski.outfit7apps.domain;

import com.vladimirpetrovski.outfit7apps.data.App;
import java.util.List;

public interface AppsRepository {

  List<App> getInstalledApps();
}
