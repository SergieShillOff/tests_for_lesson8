package com.example.rumpilstilstkin.lesson4;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bumptech.glide.Glide;
import com.example.rumpilstilstkin.lesson4.presenters.UserPresenter;
import com.example.rumpilstilstkin.lesson4.presenters.UserView;


public class MainActivity extends MvpAppCompatActivity implements UserView {

    @InjectPresenter
    UserPresenter presenter;

    ImageView imageView;
    TextView nameView;
    ProgressBar progress;
    View content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.avatar);
        nameView = findViewById(R.id.username);
        progress = findViewById(R.id.loadingView);
        content = findViewById(R.id.contentView);
    }

    @Override
    public void setImage(String imageUrl) {
        Glide.with(this)
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
