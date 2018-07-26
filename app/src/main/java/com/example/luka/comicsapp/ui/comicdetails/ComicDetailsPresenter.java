package com.example.luka.comicsapp.ui.comicdetails;

import com.example.domain.listener.RequestCallback;
import com.example.domain.model.ComicDetails;
import com.example.domain.usecase.GetComicDetailsUseCase;
import com.example.domain.usecase.UseCaseWithParam;
import com.example.luka.comicsapp.base.BasePresenter;
import com.example.luka.comicsapp.ui.mappers.ComicDetailsViewModelMapper;

import javax.inject.Inject;

public final class ComicDetailsPresenter extends BasePresenter<ComicDetailsContract.View> implements ComicDetailsContract.Presenter {

    private final UseCaseWithParam<String, ComicDetails> comicDetailsUseCase;
    private final ComicDetailsViewModelMapper comicDetailsViewModelMapper;

    @Inject
    public ComicDetailsPresenter(GetComicDetailsUseCase comicDetailsUseCase,
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
    public void start() {
        //on start logic
    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void back() {

    }
}