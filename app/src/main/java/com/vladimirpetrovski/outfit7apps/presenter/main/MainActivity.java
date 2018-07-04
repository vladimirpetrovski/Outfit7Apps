package com.vladimirpetrovski.outfit7apps.presenter.main;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.vladimirpetrovski.outfit7apps.R;
import com.vladimirpetrovski.outfit7apps.data.App;
import com.vladimirpetrovski.outfit7apps.presenter.main.AppsAdapter.OnAppClickListener;
import dagger.android.support.DaggerAppCompatActivity;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends DaggerAppCompatActivity implements MainContract.MainView,
    OnAppClickListener {

  @Inject
  MainContract.Presenter presenter;

  @BindView(R.id.apps_recycler_view)
  RecyclerView appsRecyclerView;

  private AppsAdapter appsAdapter = new AppsAdapter(this);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    appsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    appsRecyclerView.setAdapter(appsAdapter);
    presenter.takeView(this);
  }

  @Override
  protected void onDestroy() {
    presenter.dropView();
    super.onDestroy();
  }

  @Override
  public void renderApps(List<App> apps) {
    appsAdapter.submitList(apps);
  }

  @Override
  public void onAppClick(App app) {
    presenter.onAppClicked(app.getPackageName());
  }
}
