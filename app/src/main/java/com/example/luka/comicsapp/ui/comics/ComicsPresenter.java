package com.example.luka.comicsapp.ui.comics;

import com.example.domain.model.Comic;
import com.example.domain.model.ComicSearchParam;
import com.example.domain.usecase.GetComicsUseCase;
import com.example.domain.usecase.SearchComicsUseCase;
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
    private final UseCaseWithParam<ComicSearchParam, List<Comic>> searchComicUseCase;
    private final ComicViewModelMapper comicViewModelMapper;
    private int page;
    private boolean isLoading;
    private boolean searchActivated;
    private String queryString;

    @Inject
    public ComicsPresenter(GetComicsUseCase comicUseCase,
                           SearchComicsUseCase searchComicUseCase, ComicViewModelMapper comicViewModelMapper) {
        this.comicUseCase = comicUseCase;
        this.searchComicUseCase = searchComicUseCase;
        this.comicViewModelMapper = comicViewModelMapper;
    }

    @Override
    public void getComics(boolean isRefreshing) {

        if (isLoading) return;

        isLoading = true;

        if (isRefreshing) {
            page = 0;
        }

        if (searchActivated) {
            query(querySearchComics());
        } else {
            query(queryComics());
        }

        page++;
    }

    @Override
    public void searchComics(String query) {
        searchActivated = !query.isEmpty();

        queryString = query;

        getComics(true);
    }

    private Single<Consumer<ComicViewState>> querySearchComics() {
        return searchComicUseCase.execute(new ComicSearchParam(queryString, page))
                .map(comics -> comicViewModelMapper.mapToComicViewModel(comics, page))
                .map(this::onSuccess);
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