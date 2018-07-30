package com.example.domain.usecase;

import com.example.domain.model.Comic;
import com.example.domain.model.ComicSearchParam;
import com.example.domain.repository.ComicRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class SearchComicsUseCase implements UseCaseWithParam<ComicSearchParam, List<Comic>> {

    private final ComicRepository comicRepository;

    @Inject
    public SearchComicsUseCase(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    @Override
    public Single<List<Comic>> execute(ComicSearchParam comicSearchParam) {
        return comicRepository.searchComics(comicSearchParam);
    }
}
