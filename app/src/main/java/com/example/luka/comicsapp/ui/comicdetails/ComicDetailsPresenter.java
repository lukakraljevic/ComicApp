package com.example.luka.comicsapp.ui.comicdetails;

import com.example.domain.listener.RequestCallback;
import com.example.domain.model.Comic;
import com.example.domain.model.ComicDetails;
import com.example.domain.usecase.UseCaseWithParam;
import com.example.luka.comicsapp.ui.mappers.ComicDetailsViewModelMapper;

public final class ComicDetailsPresenter implements ComicDetailsContract.Presenter {

    private final ComicDetailsContract.View view;
    private final UseCaseWithParam<String, ComicDetails> comicDetailsUseCase;
    private final ComicDetailsViewModelMapper comicDetailsViewModelMapper;
    private Comic comic;

    public ComicDetailsPresenter(ComicDetailsContract.View view, UseCaseWithParam<String, ComicDetails> comicDetailsUseCase, ComicDetailsViewModelMapper comicDetailsViewModelMapper) {
        this.view = view;
        this.comicDetailsUseCase = comicDetailsUseCase;
        this.comicDetailsViewModelMapper = comicDetailsViewModelMapper;
    }

    private RequestCallback<ComicDetails> getComicDetailsCallback() {
        return new RequestCallback<ComicDetails>() {
            @Override
            public void onSuccess(ComicDetails value) {
                view.showComicDetails(comicDetailsViewModelMapper.mapToComicDetailsViewModel(value));
            }

            @Override
            public void onError(Throwable error) {
                view.alertErrorMessage();
            }
        };
    }

    @Override
    public void getComicDetails(String url) {
        comicDetailsUseCase.execute(url, getComicDetailsCallback());
    }

    @Override
    public Comic getComic() {
        return this.comic;
    }

    @Override
    public void setComic(Comic comic) {
        this.comic = comic;
    }
}
