package com.example.luka.comicsapp.ui.comicdetails;

import com.example.domain.model.ComicDetails;
import com.example.domain.model.ComicDetailsParam;
import com.example.domain.usecase.GetComicDetailsUseCase;
import com.example.domain.usecase.UseCaseWithParam;
import com.example.luka.comicsapp.base.BasePresenter;
import com.example.luka.comicsapp.ui.mappers.ComicDetailsViewModelMapper;
import com.example.luka.comicsapp.ui.viewmodel.ComicDetailsViewModel;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;

public final class ComicDetailsPresenter extends BasePresenter<ComicDetailsContract.View, ComicDetailsViewState> implements ComicDetailsContract.Presenter {

    private final UseCaseWithParam<ComicDetailsParam, ComicDetails> comicDetailsUseCase;
    private final ComicDetailsViewModelMapper comicDetailsViewModelMapper;
    private String url;

    @Inject
    public ComicDetailsPresenter(GetComicDetailsUseCase comicDetailsUseCase,
                                 ComicDetailsViewModelMapper comicDetailsViewModelMapper) {
        this.comicDetailsUseCase = comicDetailsUseCase;
        this.comicDetailsViewModelMapper = comicDetailsViewModelMapper;
    }


    @Override
    public void getComicDetails(final String url) {
        this.url = url;
        String[] parts = url.split("/");

        if (parts.length < 2) return;

        String id = parts[parts.length - 1];
        String type = parts[parts.length - 2];

        query(queryComicDetails(new ComicDetailsParam(id, type)));
    }

    private Single<Consumer<ComicDetailsViewState>> queryComicDetails(final ComicDetailsParam comicDetailsParam) {
        return comicDetailsUseCase.execute(comicDetailsParam)
                .map(comicDetailsViewModelMapper::mapToComicDetailsViewModel)
                .map(this::onSuccess);
    }

    private Consumer<ComicDetailsViewState> onSuccess(final ComicDetailsViewModel comicDetailsViewModel) {
        return viewState -> viewState.comicDetailsViewModel = comicDetailsViewModel;
    }


    @Override
    public ComicDetailsViewState initialViewState() {
        return new ComicDetailsViewState();
    }
}