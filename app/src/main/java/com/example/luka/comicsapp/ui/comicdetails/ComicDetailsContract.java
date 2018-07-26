package com.example.luka.comicsapp.ui.comicdetails;

import com.example.luka.comicsapp.base.BaseView;
import com.example.luka.comicsapp.base.ViewPresenter;

public interface ComicDetailsContract {


    interface View extends BaseView {

        void showComicDetails(ComicDetailsViewModel comicDetails);

        void alertErrorMessage();
    }

    interface Presenter extends ViewPresenter<View> {

        void getComicDetails(String url);
    }

}
