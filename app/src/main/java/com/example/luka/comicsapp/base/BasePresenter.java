package com.example.luka.comicsapp.base;

public abstract class BasePresenter<T extends BaseView> implements ViewPresenter<T> {

    protected T view;

    @Override
    public void setView(T view) {
        this.view = view;
    }

    @Override
    public void start() {
    }

    @Override
    public void activate() {
    }

    @Override
    public void deactivate() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void back() {
    }
}