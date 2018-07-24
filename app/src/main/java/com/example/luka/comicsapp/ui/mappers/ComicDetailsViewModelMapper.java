package com.example.luka.comicsapp.ui.mappers;

import com.example.domain.model.ComicDetails;
import com.example.luka.comicsapp.ui.comicdetails.ComicDetailsViewModel;

public final class ComicDetailsViewModelMapper {

    public ComicDetailsViewModel mapToComicDetailsViewModel(ComicDetails comicDetails) {
        return new ComicDetailsViewModel(comicDetails.description, comicDetails.imageUrl, comicDetails.name,
                comicDetails.characters);
    }

}
