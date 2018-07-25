package com.example.luka.comicsapp.ui.mappers;

import com.example.domain.model.Comic;
import com.example.luka.comicsapp.ui.comics.ComicViewModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class ComicViewModelMapper {

    @Inject
    public ComicViewModelMapper() {
    }

    public ComicViewModel mapToComicViewModel(List<Comic> comics) {
        return new ComicViewModel(comics);
    }
}
