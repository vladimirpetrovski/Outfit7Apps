package com.vladimirpetrovski.outfit7apps.presenter.main;

import android.os.Bundle;
import com.vladimirpetrovski.outfit7apps.R;
import com.vladimirpetrovski.outfit7apps.data.App;
import dagger.android.support.DaggerAppCompatActivity;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends DaggerAppCompatActivity implements MainContract.MainView {

  @Inject
  MainContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  public void renderApps(List<App> apps) {

  }
}
