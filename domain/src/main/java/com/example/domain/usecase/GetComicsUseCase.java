package com.example.domain.usecase;


import com.example.domain.listener.RequestCallback;
import com.example.domain.model.Comic;
import com.example.domain.repository.ComicRepository;

import java.util.List;

public final class GetComicsUseCase implements UseCaseWithParam<Integer, List<Comic>> {

    private final ComicRepository comicRepository;

    public GetComicsUseCase(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    @Override
    public void execute(final Integer page, final RequestCallback<List<Comic>> callback) {
        comicRepository.fetchTrending(page, callback);
    }

}
