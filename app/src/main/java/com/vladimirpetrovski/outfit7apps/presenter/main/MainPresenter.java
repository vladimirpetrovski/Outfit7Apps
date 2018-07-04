package com.vladimirpetrovski.outfit7apps.presenter.main;

import com.vladimirpetrovski.outfit7apps.domain.AppsRepository;
import com.vladimirpetrovski.outfit7apps.presenter.main.MainContract.MainView;
import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter {

  private MainView view;
  private AppsRepository appsRepository;

  @Inject
  MainPresenter(AppsRepository appsRepository) {
    this.appsRepository = appsRepository;
  }

  @Override
  public void takeView(MainView view) {
    this.view = view;
    initUi();
  }

  @Override
  public void dropView() {
    this.view = null;
  }

  @Override
  public void onAppClicked(String packageName) {
    view.showDialog(packageName);
  }

  private void initUi() {
    view.renderApps(appsRepository.getInstalledApps());
  }
}
