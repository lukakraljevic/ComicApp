package com.example.domain.usecase;


import com.example.domain.listener.RequestCallback;
import com.example.domain.model.Comic;
import com.example.domain.repository.ComicRepository;

import java.util.List;

public class GetComicsUseCase implements UseCase<List<Comic>> {

    private final ComicRepository comicRepository;

    public GetComicsUseCase(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    @Override
    public void execute(final RequestCallback<List<Comic>> callback) {
        try {
            comicRepository.fetchTrending(callback);
        } catch (final Throwable t) {
            callback.onError(t);
        }
    }
}
