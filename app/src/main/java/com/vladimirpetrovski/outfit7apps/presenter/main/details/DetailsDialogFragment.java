package com.vladimirpetrovski.outfit7apps.presenter.main.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.vladimirpetrovski.outfit7apps.R;
import com.vladimirpetrovski.outfit7apps.presenter.main.details.DetailsContract.DetailsView;
import dagger.android.DaggerDialogFragment;
import javax.inject.Inject;

public class DetailsDialogFragment extends DaggerDialogFragment implements DetailsView {

  private static final String EXTRA_PACKAGE_NAME = "extra_package_name";

  @BindView(R.id.details_title)
  TextView title;

  @BindView(R.id.details_package_name)
  TextView packageName;

  @BindView(R.id.details_version_code)
  TextView versionCode;

  @BindView(R.id.details_version_name)
  TextView versionName;

  @Inject
  DetailsContract.Presenter presenter;

  public static DetailsDialogFragment newInstance(String packageName) {
    Bundle args = new Bundle();
    args.putString(EXTRA_PACKAGE_NAME, packageName);
    DetailsDialogFragment fragment = new DetailsDialogFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_app_details_dialog, container, false);
    ButterKnife.bind(this, view);
    presenter.takeView(this);
    presenter.loadApp(getArguments().getString(EXTRA_PACKAGE_NAME));
    return view;
  }

  @Override
  public void onDestroy() {
    presenter.dropView();
    super.onDestroy();
  }

  @Override
  public void setTitle(String title) {
    this.title.setText(title);
  }

  @Override
  public void setPackageName(String packageName) {
    this.packageName.setText(getString(R.string.package_name_format, packageName));
  }

  @Override
  public void setVersionCode(long versionCode) {
    this.versionCode.setText(getString(R.string.version_code_format, String.valueOf(versionCode)));
  }

  @Override
  public void setVersionName(String versionName) {
    this.versionName.setText(getString(R.string.version_name_format, versionName));
  }
}
