package com.example.luka.comicsapp.ui.comics;

import com.example.domain.model.Comic;

import java.util.List;

public class ComicViewModel {

    public final List<Comic> comicList;

    public ComicViewModel(List<Comic> comicList) {
        this.comicList = comicList;
    }
}
