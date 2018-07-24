package com.example.luka.comicsapp.di.module;

import android.support.v7.app.AppCompatActivity;

import com.example.luka.comicsapp.di.component.ActivityScope;
import com.example.luka.comicsapp.ui.comicdetails.ComicDetailsContract;
import com.example.luka.comicsapp.ui.comicdetails.ComicDetailsPresenter;
import com.example.luka.comicsapp.ui.comics.ComicContract;
import com.example.luka.comicsapp.ui.comics.ComicsPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentingModule {

    private final AppCompatActivity activity;

    public PresentingModule(final AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public AppCompatActivity provideActivityContext() {
        return this.activity;
    }

    @Provides
    @ActivityScope
    public ComicContract.Presenter provideComicsPresenter(final ComicsPresenter presenter) {
        return presenter;
    }

    @Provides
    @ActivityScope
    public ComicDetailsContract.Presenter provideComicDetailsPresenter(final ComicDetailsPresenter presenter) {
        return presenter;
    }
}