package com.example.rumpilstilstkin.lesson4.presenters.home;

import com.arellomobile.mvp.MvpView;

public interface RepsView extends MvpView {

    void showError(Throwable e);

    void showLoading();

    void hideLoading();
}
