package com.example.luka.comicsapp.ui.comics;


public interface ComicContract {

    interface View {

        void renderComics(ComicViewModel comics);

        void renderComicsRefresh(ComicViewModel param);

        void alertErrorMessage();
    }

    interface Presenter {

        void getComics();

        void setLoading(boolean b);

        void performRefresh();

        boolean getLoading();
    }
}
