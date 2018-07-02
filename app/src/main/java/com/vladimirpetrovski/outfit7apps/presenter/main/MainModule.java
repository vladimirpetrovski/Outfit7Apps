package com.vladimirpetrovski.outfit7apps.presenter.main;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainModule {

  @Binds
  abstract MainContract.Presenter provideMainPresenter(MainPresenter presenter);
}
