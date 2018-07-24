package com.example.luka.comicsapp.ui.comics;


import com.example.luka.comicsapp.base.BasePresenter;
import com.example.luka.comicsapp.base.BaseView;

public interface ComicContract {

    interface View extends BaseView {

        void renderComics(ComicViewModel comics, int page);

        void alertErrorMessage();
    }

    interface Presenter extends BasePresenter<View>{

        void getComics(boolean isRefreshing);
    }
}
