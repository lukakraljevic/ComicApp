package com.example.luka.comicsapp.ui.comicdetails;

public interface ComicDetailsContract {


    interface View {

        void showComicDetails(ComicDetailsViewModel comicDetails);

        void alertErrorMessage();

    }

    interface Presenter {

        void getComicDetails(String url);
    }

}
