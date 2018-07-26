package com.example.luka.comicsapp.base;

public interface ViewPresenter<T> {

    void setView(T view);

    void start();

    void activate();

    void deactivate();

    void stop();

    void destroy();

    void back();
}
