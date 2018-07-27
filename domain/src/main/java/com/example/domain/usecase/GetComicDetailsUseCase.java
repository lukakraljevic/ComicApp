package com.example.domain.usecase;

import com.example.domain.model.ComicDetails;
import com.example.domain.repository.ComicRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public final class GetComicDetailsUseCase implements UseCaseWithParam<String, ComicDetails> {

    private final ComicRepository comicRepository;

    @Inject
    public GetComicDetailsUseCase(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    @Override
    public Single<ComicDetails> execute(String param) {
        return comicRepository.getComicDetails(param);
    }
}
