package com.vladimirpetrovski.outfit7apps.data;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode
public class App {

  String packageName;
  String name;
  long versionCode;
  String versionName;
}
