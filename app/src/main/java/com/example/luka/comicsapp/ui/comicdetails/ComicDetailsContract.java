package com.example.luka.comicsapp.ui.comicdetails;

import com.example.luka.comicsapp.base.BaseView;
import com.example.luka.comicsapp.base.ViewPresenter;

public interface ComicDetailsContract {


    interface View extends BaseView {
    }

    interface Presenter extends ViewPresenter<View, ComicDetailsViewState> {

        void getComicDetails(String url);
    }

}
