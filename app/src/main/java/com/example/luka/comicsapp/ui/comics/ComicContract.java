package com.example.luka.comicsapp.ui.comics;


public interface ComicContract {

    interface View {

        void renderComics(ComicViewModel comics, int page);

        void alertErrorMessage();
    }

    interface Presenter {

        void getComics(boolean isRefreshing);
    }
}
