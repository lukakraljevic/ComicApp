package com.example.luka.comicsapp.ui.comicdetails;

import com.example.luka.comicsapp.base.BasePresenter;
import com.example.luka.comicsapp.base.BaseView;

public interface ComicDetailsContract {


    interface View extends BaseView {

        void showComicDetails(ComicDetailsViewModel comicDetails);

        void alertErrorMessage();
    }

    interface Presenter extends BasePresenter<View> {

        void getComicDetails(String url);
    }

}
