package com.example.luka.comicsapp.di.activity;

import com.example.luka.comicsapp.ui.comicdetails.ComicDetailsContract;
import com.example.luka.comicsapp.ui.comicdetails.ComicDetailsPresenter;
import com.example.luka.comicsapp.ui.comics.ComicContract;
import com.example.luka.comicsapp.ui.comics.ComicsPresenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ActivityPresenterModule {

    @Binds
    public abstract ComicContract.Presenter provideComicsPresenter(final ComicsPresenter presenter);

    @Binds
    public abstract ComicDetailsContract.Presenter provideComicDetailsPresenter(final ComicDetailsPresenter presenter);
}