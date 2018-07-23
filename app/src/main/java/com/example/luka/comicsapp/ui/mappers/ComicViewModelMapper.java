package com.example.luka.comicsapp.ui.mappers;

import com.example.domain.model.Comic;
import com.example.luka.comicsapp.ui.comics.ComicViewModel;

import java.util.List;

public final class ComicViewModelMapper {

    public ComicViewModel mapToComicViewModel(List<Comic> comics) {
        return new ComicViewModel(comics);
    }

}
