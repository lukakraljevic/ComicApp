package com.example.luka.comicsapp.ui.comics;

import com.example.domain.listener.RequestCallback;
import com.example.domain.model.Comic;
import com.example.domain.usecase.UseCaseWithParam;
import com.example.luka.comicsapp.ui.listener.LazyLoadingListener;
import com.example.luka.comicsapp.ui.mappers.ComicViewModelMapper;

import java.util.List;

public final class ComicsPresenter implements ComicContract.Presenter, LazyLoadingListener {

    private final ComicContract.View view;
    private final UseCaseWithParam<Integer, List<Comic>> comicUseCase;
    private final ComicViewModelMapper comicViewModelMapper;
    private int page;
    private boolean isLoading;

    public ComicsPresenter(ComicContract.View view, UseCaseWithParam<Integer, List<Comic>> comicUseCase,
                           ComicViewModelMapper comicViewModelMapper) {
        this.view = view;
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

        comicUseCase.execute(page, getComicCallback());
        page++;
    }

    private RequestCallback<List<Comic>> getComicCallback() {
        return new RequestCallback<List<Comic>>() {
            @Override
            public void onSuccess(List<Comic> value) {
                view.renderComics(comicViewModelMapper.mapToComicViewModel(value), page);
                isLoading = false;
            }

            @Override
            public void onError(Throwable throwable) {
                view.alertErrorMessage();
            }
        };
    }

    @Override
    public void onBottomReached() {
        getComics(false);
    }
}
