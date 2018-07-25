package com.example.data.mappers;

import com.example.data.apimodel.comicdetails.ComicCharacterApiModel;
import com.example.data.apimodel.comicdetails.ComicDetailsApiModel;
import com.example.domain.model.ComicCharacter;
import com.example.domain.model.ComicDetails;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class ComicDetailsMapper {

    @Inject
    public ComicDetailsMapper() {
    }

    public ComicDetails mapComicDetailsToModel(ComicDetailsApiModel apiModel) {

        final List<ComicCharacter> characters = new ArrayList<>();
        for (ComicCharacterApiModel comicCharacterApiModel : apiModel.characters) {
            characters.add(createComicCharacter(comicCharacterApiModel));
        }

        return new ComicDetails(apiModel.id, apiModel.description, apiModel.image.screenUrl,
                apiModel.name, characters);
    }

    private ComicCharacter createComicCharacter(ComicCharacterApiModel comicCharacterApiModel) {
        return new ComicCharacter(comicCharacterApiModel.id, comicCharacterApiModel.name,
                comicCharacterApiModel.siteDetailUrl);
    }

}
