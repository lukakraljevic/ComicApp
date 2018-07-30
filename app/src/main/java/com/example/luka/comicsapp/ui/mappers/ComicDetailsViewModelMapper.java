package com.example.luka.comicsapp.ui.mappers;

import com.example.domain.model.ComicDetails;
import com.example.luka.comicsapp.ui.viewmodel.ComicDetailsViewModel;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class ComicDetailsViewModelMapper {


    @Inject
    public ComicDetailsViewModelMapper() {
    }

    public ComicDetailsViewModel mapToComicDetailsViewModel(ComicDetails comicDetails) {
        return new ComicDetailsViewModel(comicDetails.description, comicDetails.imageUrl, comicDetails.name,
                comicDetails.characters);
    }

}
