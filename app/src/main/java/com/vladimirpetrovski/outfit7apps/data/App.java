package com.vladimirpetrovski.outfit7apps.data;

import lombok.Data;

@Data
public class App {
  String name;
  String imagePath;
  String packageName;
  String versionCode;
  String versionName;
}
