package com.example.domain.repository;

import com.example.domain.listener.RequestCallback;
import com.example.domain.model.Comic;
import com.example.domain.model.ComicDetails;

import java.util.List;

public interface ComicRepository {

    void fetchTrending(RequestCallback<List<Comic>> callback);

    void getComicDetails(String url, RequestCallback<ComicDetails> callback);
}
