package com.vladimirpetrovski.outfit7apps.presenter.main;

import com.vladimirpetrovski.outfit7apps.data.App;
import com.vladimirpetrovski.outfit7apps.presenter.BasePresenter;
import com.vladimirpetrovski.outfit7apps.presenter.BaseView;
import java.util.List;

public interface MainContract {

  interface MainView extends BaseView<Presenter> {

    void renderApps(List<App> apps);

    void showDialog(String packageName);
  }

  interface Presenter extends BasePresenter<MainView> {

    void onAppClicked(String packageName);
  }
}
