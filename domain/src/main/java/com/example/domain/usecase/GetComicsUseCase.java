package com.example.domain.usecase;


import com.example.domain.model.Comic;
import com.example.domain.repository.ComicRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public final class GetComicsUseCase implements UseCaseWithParam<Integer, List<Comic>> {

    private final ComicRepository comicRepository;

    @Inject
    public GetComicsUseCase(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    @Override
    public Single<List<Comic>> execute(final Integer page) {
        return comicRepository.fetchTrending(page);
    }

}
