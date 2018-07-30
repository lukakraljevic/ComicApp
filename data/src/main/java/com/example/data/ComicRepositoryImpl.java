package com.example.data;

import android.support.annotation.Nullable;

import com.example.data.mappers.ComicDetailsMapper;
import com.example.data.mappers.ComicMapper;
import com.example.data.networking.ComicService;
import com.example.domain.model.Comic;
import com.example.domain.model.ComicDetails;
import com.example.domain.repository.ComicRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class ComicRepositoryImpl implements ComicRepository {

    private static final String API_KEY = "2e7a75541721af0132f5c1c7729619708a8c3438";
    private static final String FORMAT = "json";
    private static final int LIMIT = 10;
    private final ComicService comicService;
    private final ComicMapper comicMapper;
    private final ComicDetailsMapper comicDetailsMapper;

    @Inject
    public ComicRepositoryImpl(ComicService apiService, ComicMapper comicMapper, ComicDetailsMapper comicDetailsMapper) {
        this.comicService = apiService;
        this.comicMapper = comicMapper;
        this.comicDetailsMapper = comicDetailsMapper;
    }

    @Override
    public Single<List<Comic>> fetchTrending(final int page) {
        return comicService.getComics(API_KEY, FORMAT, LIMIT, page * LIMIT)
                .map(comicMapper::mapComicsToModel);
    }

    @Override
    @Nullable
    public Single<ComicDetails> getComicDetails(String url) {
        String[] parts = url.split("/");

        if (parts.length == 0) return null;

        String id = parts[parts.length - 1];

        return comicService.getComicDetails(id, API_KEY, FORMAT)
                .map(comicDetailsMapper::mapComicDetailsToModel);
    }
}
