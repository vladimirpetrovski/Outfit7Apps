package com.vladimirpetrovski.outfit7apps.presenter.main.details;

import com.vladimirpetrovski.outfit7apps.presenter.BasePresenter;
import com.vladimirpetrovski.outfit7apps.presenter.BaseView;

public interface DetailsContract {

  interface DetailsView extends BaseView<Presenter> {

    void setTitle(String title);

    void setPackageName(String packageName);

    void setVersionCode(long versionCode);

    void setVersionName(String versionName);

  }

  interface Presenter extends BasePresenter<DetailsView> {

    void loadApp(String packageName);

    void onAppClicked();
  }

}
