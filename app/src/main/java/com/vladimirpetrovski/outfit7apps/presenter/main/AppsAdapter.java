package com.vladimirpetrovski.outfit7apps.presenter.main;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.vladimirpetrovski.outfit7apps.R;
import com.vladimirpetrovski.outfit7apps.data.App;
import com.vladimirpetrovski.outfit7apps.presenter.main.AppsAdapter.AppViewHolder;

public class AppsAdapter extends ListAdapter<App, AppViewHolder> {

  private static final String TAG = AppsAdapter.class.getSimpleName();

  private OnAppClickListener listener;

  AppsAdapter(OnAppClickListener listener) {
    super(new ItemCallback());
    this.listener = listener;
  }

  @NonNull
  @Override
  public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new AppViewHolder(
        LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_app, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull AppViewHolder holder, int position) {
    final App item = getItem(position);
    holder.itemView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        listener.onAppClick(item);
      }
    });
    holder.itemTitle.setText(item.getName());
    try {
      Drawable icon = holder.itemView.getContext().getPackageManager()
          .getApplicationIcon(item.getPackageName());
      holder.itemIcon.setImageDrawable(icon);

    } catch (PackageManager.NameNotFoundException e) {
      Log.e(TAG, e.getMessage());
    }
  }

  static class AppViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_icon)
    ImageView itemIcon;

    @BindView(R.id.item_title)
    TextView itemTitle;

    AppViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

  static class ItemCallback extends DiffUtil.ItemCallback<App> {

    @Override
    public boolean areItemsTheSame(App oldItem, App newItem) {
      return oldItem.getPackageName().equals(newItem.getPackageName());
    }

    @Override
    public boolean areContentsTheSame(App oldItem, App newItem) {
      return oldItem.equals(newItem);
    }
  }

  public interface OnAppClickListener {

    void onAppClick(App app);
  }
}
