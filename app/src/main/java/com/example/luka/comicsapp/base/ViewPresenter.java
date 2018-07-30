package com.example.luka.comicsapp.base;

import io.reactivex.Flowable;

public interface ViewPresenter<View, Data> {

    void setView(View view);

    void start();

    void activate();

    void deactivate();

    void stop();

    void destroy();

    void back();

    Flowable<Data> viewState();
}
