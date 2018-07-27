package com.example.luka.comicsapp.ui.comics;

import com.example.domain.model.Comic;
import com.example.domain.usecase.GetComicsUseCase;
import com.example.domain.usecase.UseCaseWithParam;
import com.example.luka.comicsapp.base.BasePresenter;
import com.example.luka.comicsapp.ui.mappers.ComicViewModelMapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

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
    public void getComics(boolean isRefreshing) {

        if (isLoading) return;

        isLoading = true;

        if (isRefreshing) {
            page = 0;
        }

        comicUseCase.execute(page).observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(this::onSuccess, this::onError);

        page++;
    }

    private void onSuccess(List<Comic> value) {
        view.renderComics(comicViewModelMapper.mapToComicViewModel(value), page);
        isLoading = false;
    }

    private void onError(Throwable throwable) {
        view.alertErrorMessage();
    }
}