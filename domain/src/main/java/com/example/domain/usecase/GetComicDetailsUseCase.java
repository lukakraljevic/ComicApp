package com.example.domain.usecase;

import com.example.domain.model.ComicDetails;
import com.example.domain.model.ComicDetailsParam;
import com.example.domain.repository.ComicRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public final class GetComicDetailsUseCase implements UseCaseWithParam<ComicDetailsParam, ComicDetails> {

    private final ComicRepository comicRepository;

    @Inject
    public GetComicDetailsUseCase(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    @Override
    public Single<ComicDetails> execute(ComicDetailsParam comicDetailsParam) {
        return comicRepository.getComicDetails(comicDetailsParam);
    }
}
