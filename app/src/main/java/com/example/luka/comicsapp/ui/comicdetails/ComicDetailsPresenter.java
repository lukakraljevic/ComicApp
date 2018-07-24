package com.example.luka.comicsapp.ui.comicdetails;

import com.example.domain.listener.RequestCallback;
import com.example.domain.model.ComicDetails;
import com.example.domain.usecase.UseCaseWithParam;
import com.example.luka.comicsapp.di.component.ActivityScope;
import com.example.luka.comicsapp.ui.mappers.ComicDetailsViewModelMapper;

import javax.inject.Inject;

@ActivityScope
public final class ComicDetailsPresenter implements ComicDetailsContract.Presenter {

    ComicDetailsContract.View view;

    private final UseCaseWithParam<String, ComicDetails> comicDetailsUseCase;

    private final ComicDetailsViewModelMapper comicDetailsViewModelMapper;

    @Inject
    public ComicDetailsPresenter(UseCaseWithParam<String, ComicDetails> comicDetailsUseCase,
                                 ComicDetailsViewModelMapper comicDetailsViewModelMapper) {
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
    public void setView(ComicDetailsContract.View view) {
        this.view = view;
    }
}