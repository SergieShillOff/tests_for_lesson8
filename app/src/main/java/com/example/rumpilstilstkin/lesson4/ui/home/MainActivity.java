package com.example.rumpilstilstkin.lesson4.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;
import com.example.rumpilstilstkin.lesson4.R;
import com.example.rumpilstilstkin.lesson4.presenters.home.RepsPresenter;
import com.example.rumpilstilstkin.lesson4.presenters.home.RepsView;
import com.example.rumpilstilstkin.lesson4.presenters.home.UserPresenter;
import com.example.rumpilstilstkin.lesson4.presenters.home.UserView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpAppCompatActivity
        implements UserView, RepsView {

    @InjectPresenter
    UserPresenter presenter;

    @InjectPresenter
    RepsPresenter repsPresenter;

    @BindView(R.id.avatar)  ImageView imageView;
    @BindView(R.id.username) TextView nameView;
    @BindView(R.id.loadingView) ProgressBar progress;
    @BindView(R.id.contentView) View content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void setImage(String imageUrl) {
      /*  Glide.with(this)
                .load(imageUrl)
                .into(imageView);*/

        Picasso.get()
                .load(imageUrl)
                .into(imageView);
    }

    @Override
    public void setName(String name) {
        nameView.setText(name);
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        progress.setVisibility(View.GONE);
        content.setVisibility(View.GONE);
    }

    @Override
    public void startLoad() {
        progress.setVisibility(View.VISIBLE);
        content.setVisibility(View.GONE);
    }

    @Override
    public void finishLoad() {
        progress.setVisibility(View.GONE);
        content.setVisibility(View.VISIBLE);
    }
}
