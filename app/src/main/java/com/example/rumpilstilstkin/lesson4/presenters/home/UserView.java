package com.example.rumpilstilstkin.lesson4.presenters.home;

import com.arellomobile.mvp.MvpView;

public interface UserView extends MvpView {
    void setName(String name);

    void setImage(String imageUrl);

    void showError(Throwable e);

    void startLoad();

    void finishLoad();
}
