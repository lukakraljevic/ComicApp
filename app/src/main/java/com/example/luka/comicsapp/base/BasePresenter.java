package com.example.luka.comicsapp.base;

public abstract class BasePresenter<T extends BaseView> implements IBasePresenter<T> {

    protected T view;

    @Override
    public void setView(T view) {
        this.view = view;
    }

}