package com.example.luka.comicsapp.ui.comics;

import com.example.domain.listener.RequestCallback;
import com.example.domain.model.Comic;
import com.example.domain.usecase.UseCaseWithParam;
import com.example.luka.comicsapp.ui.mappers.ComicViewModelMapper;

import java.util.List;

public final class ComicsPresenter implements ComicContract.Presenter {

    private final ComicContract.View view;
    private final UseCaseWithParam<Integer, List<Comic>> comicUseCase;
    private final ComicViewModelMapper comicViewModelMapper;
    private int page;
    private boolean isLoading;


    public ComicsPresenter(ComicContract.View view, UseCaseWithParam<Integer, List<Comic>> comicUseCase, ComicViewModelMapper comicViewModelMapper) {
        this.view = view;
        this.comicUseCase = comicUseCase;
        this.comicViewModelMapper = comicViewModelMapper;
    }

    @Override
    public void getComics() {
        comicUseCase.execute(page, getComicCallback());
        page++;
    }

    @Override
    public void setLoading(boolean isLoading) {
        this.isLoading = isLoading;
    }

    @Override
    public void performRefresh() {
        this.page = 0;
    }

    @Override
    public boolean getLoading() {
        return this.isLoading;
    }

    private RequestCallback<List<Comic>> getComicCallback() {
        return new RequestCallback<List<Comic>>() {
            @Override
            public void onSuccess(List<Comic> value) {
                if (isLoading) {
                    view.renderComics(comicViewModelMapper.mapToComicViewModel(value));
                } else {
                    view.renderComicsRefresh(comicViewModelMapper.mapToComicViewModel(value));
                }
            }

            @Override
            public void onError(Throwable throwable) {
                view.alertErrorMessage();
            }
        };
    }
}
