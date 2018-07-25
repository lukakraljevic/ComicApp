package com.example.luka.comicsapp.di.component;

import com.example.luka.comicsapp.ui.comicdetails.ComicDetailsActivity;
import com.example.luka.comicsapp.ui.comics.ComicsActivity;

public interface ActivityComponentInjects {
    void inject(ComicsActivity comicsActivity);
    void inject(ComicDetailsActivity comicDetailsActivity);
}
