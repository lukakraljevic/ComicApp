package com.example.data.mappers;

import com.example.data.apimodel.comic.ComicApiModel;
import com.example.domain.model.Comic;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class ComicMapper {

    @Inject
    public ComicMapper() {
    }

    public Comic mapComicsToModel(ComicApiModel apiModel) {

        return new Comic(apiModel.id, apiModel.apiDetailUrl, apiModel.airDate, apiModel.description,
                        apiModel.comicSeries.name, apiModel.image.smallUrl, apiModel.image.screenUrl,
                        apiModel.episodeNumber, apiModel.dateLastUpdated, apiModel.name);
    }
}
