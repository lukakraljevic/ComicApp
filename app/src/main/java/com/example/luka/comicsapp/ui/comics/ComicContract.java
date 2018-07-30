package com.example.luka.comicsapp.ui.comics;


import com.example.luka.comicsapp.base.BaseView;
import com.example.luka.comicsapp.base.ViewPresenter;

public interface ComicContract {

    interface View extends BaseView {
    }

    interface Presenter extends ViewPresenter<View, ComicViewState> {

        void getComics(boolean isRefreshing);

        void searchComics(String query);
    }
}
