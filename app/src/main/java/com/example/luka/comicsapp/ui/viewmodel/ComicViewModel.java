package com.example.luka.comicsapp.ui.viewmodel;

import com.example.domain.model.Comic;

import java.util.ArrayList;
import java.util.List;

public final class ComicViewModel {

    public final List<Comic> comicList;

    public final int page;

    public ComicViewModel(List<Comic> comicList, int page) {
        this.comicList = comicList;
        this.page = page;
    }

    public ComicViewModel() {
        this.comicList = new ArrayList<>();
        this.page = 0;
    }
}
