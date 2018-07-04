package com.vladimirpetrovski.outfit7apps.presenter.main;

import com.vladimirpetrovski.outfit7apps.presenter.main.details.DetailsContract;
import com.vladimirpetrovski.outfit7apps.presenter.main.details.DetailsDialogFragment;
import com.vladimirpetrovski.outfit7apps.presenter.main.details.DetailsPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainModule {

  @Binds
  abstract MainContract.Presenter provideMainPresenter(MainPresenter presenter);

  @ContributesAndroidInjector
  abstract DetailsDialogFragment provideDetailsDialogFragment();

  @Binds
  abstract DetailsContract.Presenter provideDetailsPresenter(DetailsPresenter presenter);
}
