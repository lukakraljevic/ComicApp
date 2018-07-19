package com.example.data.mappers;

import com.example.data.apimodel.comicdetails.ComicDetailsApiModel;
import com.example.domain.model.ComicDetails;

public class ComicDetailsMapper {

    public ComicDetails mapComicDetailsToModel(ComicDetailsApiModel apiModel) {

        return new ComicDetails(apiModel.id, apiModel.description, apiModel.image.screenUrl,
                apiModel.name);
    }

}
