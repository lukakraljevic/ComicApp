package com.example.domain.repository;

import com.example.domain.model.Comic;
import com.example.domain.model.ComicDetails;
import com.example.domain.model.ComicSearchParam;

import java.util.List;

import io.reactivex.Single;

public interface ComicRepository {

    Single<List<Comic>> fetchTrending(int page);

    Single<ComicDetails> getComicDetails(String url);

    Single<List<Comic>> searchComics(ComicSearchParam comicSearchParam);
}
