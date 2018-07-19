package com.example.data.mappers;

import com.example.data.apimodel.comic.ComicApiModel;
import com.example.data.apimodel.comicdetails.ComicDetailsApiModel;
import com.example.domain.model.Comic;
import com.example.domain.model.ComicDetails;

public class ComicMapper {

    public Comic mapComicsToModel(ComicApiModel apiModel) {

        return new Comic(apiModel.id, apiModel.apiDetailUrl, apiModel.airDate, apiModel.description,
                                apiModel.name, apiModel.image.smallUrl);
    }


}
