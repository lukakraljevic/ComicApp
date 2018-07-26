package com.example.luka.comicsapp.ui.comicdetails;

import com.example.luka.comicsapp.base.BaseView;
import com.example.luka.comicsapp.base.IBasePresenter;

public interface ComicDetailsContract {


    interface View extends BaseView {

        void showComicDetails(ComicDetailsViewModel comicDetails);

        void alertErrorMessage();
    }

    interface Presenter extends IBasePresenter<View> {

        void getComicDetails(String url);
    }

}
