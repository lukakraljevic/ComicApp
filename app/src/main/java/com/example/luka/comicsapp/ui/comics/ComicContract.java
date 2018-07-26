package com.example.luka.comicsapp.ui.comics;


import com.example.luka.comicsapp.base.BaseView;
import com.example.luka.comicsapp.base.IBasePresenter;

public interface ComicContract {

    interface View extends BaseView {

        void renderComics(ComicViewModel comics, int page);

        void alertErrorMessage();
    }

    interface Presenter extends IBasePresenter<View> {

        void getComics(boolean isRefreshing);
    }
}
