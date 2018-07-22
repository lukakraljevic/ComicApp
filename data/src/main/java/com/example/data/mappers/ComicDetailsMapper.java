package com.example.data.mappers;

import com.example.data.apimodel.comicdetails.ComicCharacterApiModel;
import com.example.data.apimodel.comicdetails.ComicDetailsApiModel;
import com.example.domain.model.ComicCharacter;
import com.example.domain.model.ComicDetails;

import java.util.ArrayList;
import java.util.List;

public class ComicDetailsMapper {

    public ComicDetails mapComicDetailsToModel(ComicDetailsApiModel apiModel) {

        List<ComicCharacter> characters = new ArrayList<>();
        for (ComicCharacterApiModel comicCharacterApiModel : apiModel.charachters) {
            characters.add(new ComicCharacter(comicCharacterApiModel.id, comicCharacterApiModel.name,
                    comicCharacterApiModel.siteDetailUrl));
        }

        return new ComicDetails(apiModel.id, apiModel.description, apiModel.image.screenUrl,
                apiModel.name, characters);
    }

}
