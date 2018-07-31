package com.example.domain.repository;

import com.example.domain.model.Comic;
import com.example.domain.model.ComicDetails;
import com.example.domain.model.ComicDetailsParam;

import java.util.List;

import io.reactivex.Single;

public interface ComicRepository {

    Single<List<Comic>> fetchTrending(int page);

    Single<ComicDetails> getDetails(ComicDetailsParam comicDetailsParam);
}
