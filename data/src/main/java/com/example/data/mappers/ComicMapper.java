package com.example.data.mappers;

import com.example.data.apimodel.comic.ComicApiModel;
import com.example.data.apimodel.comic.ComicResponse;
import com.example.domain.model.Comic;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class ComicMapper {

    @Inject
    public ComicMapper() {
    }

    public List<Comic> mapComicsToModel(ComicResponse comicResponse) {

        if (comicResponse == null) {
            return null;
        }

        final List<Comic> comics = new ArrayList<>();

        for (ComicApiModel apiModel : comicResponse.comics) {
            comics.add(new Comic(apiModel.id, apiModel.apiDetailUrl, apiModel.airDate, apiModel.dateAdded, apiModel.description,
                    apiModel.comicSeries == null ? "" : apiModel.comicSeries.name,
                    apiModel.image == null ? "" : apiModel.image.smallUrl,
                    apiModel.image == null ? "": apiModel.image.screenUrl,
                    apiModel.episodeNumber, apiModel.dateLastUpdated, apiModel.name));
        }

        return comics;
    }
}
