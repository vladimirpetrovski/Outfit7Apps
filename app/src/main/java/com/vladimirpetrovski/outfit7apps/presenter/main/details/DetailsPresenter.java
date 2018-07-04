package com.vladimirpetrovski.outfit7apps.presenter.main.details;

import com.vladimirpetrovski.outfit7apps.data.App;
import com.vladimirpetrovski.outfit7apps.domain.AppsLauncher;
import com.vladimirpetrovski.outfit7apps.domain.AppsRepository;
import com.vladimirpetrovski.outfit7apps.presenter.main.details.DetailsContract.DetailsView;
import javax.inject.Inject;

public class DetailsPresenter implements DetailsContract.Presenter {

  private DetailsView view;
  private AppsRepository appsRepository;
  private AppsLauncher appsLauncher;

  @Inject
  DetailsPresenter(AppsRepository appsRepository, AppsLauncher appsLauncher) {
    this.appsRepository = appsRepository;
    this.appsLauncher = appsLauncher;
  }

  @Override
  public void takeView(DetailsView view) {
    this.view = view;
  }

  @Override
  public void dropView() {
    this.view = null;
  }

  @Override
  public void loadApp(String packageName) {
    App app = appsRepository.getApp(packageName);
    initUi(app);
  }

  @Override
  public void onAppClicked(String packageName) {
    appsLauncher.launchPackage(packageName);
  }

  private void initUi(App app) {
    view.setTitle(app.getName());
    view.setPackageName(app.getPackageName());
    view.setVersionCode(app.getVersionCode());
    view.setVersionName(app.getVersionName());
  }
}
