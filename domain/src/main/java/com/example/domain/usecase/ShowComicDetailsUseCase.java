package com.example.domain.usecase;

import com.example.domain.listener.RequestCallback;
import com.example.domain.model.ComicDetails;
import com.example.domain.repository.ComicRepository;

public final class ShowComicDetailsUseCase implements UseCaseWithParam<String, ComicDetails> {

    private final ComicRepository comicRepository;

    public ShowComicDetailsUseCase(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    @Override
    public void execute(String param, RequestCallback<ComicDetails> callback) {
        comicRepository.getComicDetails(param, callback);
    }
}
