package com.shadow1329.latestnews.presenter;

import com.shadow1329.latestnews.view.MvpView;

public interface MvpPresenter<V extends MvpView> {

    void attachView(MvpView mvpView);
    void detachView();
}
