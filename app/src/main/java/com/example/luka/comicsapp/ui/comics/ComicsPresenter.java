package com.example.luka.comicsapp.ui.comics;

import com.example.domain.model.Comic;
import com.example.domain.usecase.GetComicsUseCase;
import com.example.domain.usecase.UseCaseWithParam;
import com.example.luka.comicsapp.base.BasePresenter;
import com.example.luka.comicsapp.ui.mappers.ComicViewModelMapper;
import com.example.luka.comicsapp.ui.viewmodel.ComicViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;

public final class ComicsPresenter extends BasePresenter<ComicContract.View, ComicViewState> implements ComicContract.Presenter {

    private final UseCaseWithParam<Integer, List<Comic>> comicUseCase;
    private final ComicViewModelMapper comicViewModelMapper;
    private int page;
    private boolean isLoading;

    @Inject
    public ComicsPresenter(GetComicsUseCase comicUseCase,
                           ComicViewModelMapper comicViewModelMapper) {
        this.comicUseCase = comicUseCase;
        this.comicViewModelMapper = comicViewModelMapper;
    }

    @Override
    public void getComics(boolean isRefreshing) {

        if (isLoading) return;

        isLoading = true;

        if (isRefreshing) {
            page = 0;
        }

        query(queryComics());

        page++;
    }

    private Single<Consumer<ComicViewState>> queryComics() {
        return comicUseCase.execute(page)
                .map(comics -> comicViewModelMapper.mapToComicViewModel(comics, page))
                .map(this::onSuccess);
    }

    private Consumer<ComicViewState> onSuccess(ComicViewModel comicViewModel) {
        return viewState -> {
            viewState.comicViewModel = comicViewModel;
            viewState.isLoading = false;
            isLoading = false;
        };
    }

    @Override
    public ComicViewState initialViewState() {
        return new ComicViewState();
    }
}