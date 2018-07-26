package com.example.luka.comicsapp.ui.comics;

import com.example.domain.listener.RequestCallback;
import com.example.domain.model.Comic;
import com.example.domain.usecase.GetComicsUseCase;
import com.example.domain.usecase.UseCaseWithParam;
import com.example.luka.comicsapp.base.BasePresenter;
import com.example.luka.comicsapp.ui.mappers.ComicViewModelMapper;

import java.util.List;

import javax.inject.Inject;

public final class ComicsPresenter extends BasePresenter<ComicContract.View> implements ComicContract.Presenter {

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
}