package com.example.luka.comicsapp.base;

public interface BasePresenter<T extends BaseView> {

    void setView(T view);
}
