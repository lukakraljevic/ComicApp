package com.example.luka.comicsapp.ui.comicdetails;

import com.example.domain.model.Comic;

public interface ComicDetailsContract {


    interface View {

        void showComicDetails(ComicDetailsViewModel comicDetails);

        void alertErrorMessage();

    }

    interface Presenter {

        void getComicDetails(String url);

        Comic getComic();

        void setComic(Comic comic);
    }

}
