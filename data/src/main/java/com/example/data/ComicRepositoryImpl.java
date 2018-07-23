package com.example.data;

import com.example.data.apimodel.comic.ComicApiModel;
import com.example.data.apimodel.comic.ComicResponse;
import com.example.data.apimodel.comicdetails.ComicDetailsResponse;
import com.example.data.apimodel.comicdetails.ComicDetailsApiModel;
import com.example.data.mappers.ComicDetailsMapper;
import com.example.data.mappers.ComicMapper;
import com.example.data.networking.ComicService;
import com.example.domain.listener.RequestCallback;
import com.example.domain.model.Comic;
import com.example.domain.model.ComicDetails;
import com.example.domain.repository.ComicRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComicRepositoryImpl implements ComicRepository {

    private static final String API_KEY = "2e7a75541721af0132f5c1c7729619708a8c3438";
    private static final String FORMAT = "json";
    private static final int LIMIT = 10;

    private final ComicService comicService;
    private final ComicMapper comicMapper;
    private final ComicDetailsMapper comicDetailsMapper;

    public ComicRepositoryImpl(ComicService apiService, ComicMapper comicMapper, ComicDetailsMapper comicDetailsMapper) {
        this.comicService = apiService;
        this.comicMapper = comicMapper;
        this.comicDetailsMapper = comicDetailsMapper;
    }

    @Override
    public void fetchTrending(final int page, final RequestCallback<List<Comic>> callback) {
        comicService.getComics(API_KEY, FORMAT, LIMIT, page * LIMIT).enqueue(new Callback<ComicResponse>() {
            @Override
            public void onResponse(Call<ComicResponse> call, Response<ComicResponse> response) {
                final ComicResponse body = response.body();

                if (body == null) {
                    return;
                }

                final List<Comic> comics = new ArrayList<>();

                for (ComicApiModel comic : body.comics) {
                    comics.add(comicMapper.mapComicsToModel(comic));
                }

                callback.onSuccess(comics);
            }

            @Override
            public void onFailure(Call<ComicResponse> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    @Override
    public void getComicDetails(String url, final RequestCallback<ComicDetails> callback) {
        String[] parts = url.split("/");

        if (parts.length == 0) return;

        String id = parts[parts.length - 1];

        comicService.getComicDetails(id, API_KEY, FORMAT).enqueue(new Callback<ComicDetailsResponse>() {
            @Override
            public void onResponse(Call<ComicDetailsResponse> call, Response<ComicDetailsResponse> response) {
                final ComicDetailsApiModel body = response.body().comicDetails;

                if (body == null) {
                    return;
                }

                ComicDetails comicDetails = comicDetailsMapper.mapComicDetailsToModel(body);

                callback.onSuccess(comicDetails);
            }

            @Override
            public void onFailure(Call<ComicDetailsResponse> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
