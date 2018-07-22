package com.example.luka.comicsapp.ui.comics;

import com.example.domain.listener.RequestCallback;
import com.example.domain.model.Comic;
import com.example.domain.usecase.UseCaseWithParam;
import com.example.luka.comicsapp.ui.mappers.ComicViewModelMapper;

import java.util.List;

public class ComicsPresenter implements ComicContract.Presenter {

    private final ComicContract.View view;
    private final UseCaseWithParam<Integer, List<Comic>> comicUseCase;
    private final ComicViewModelMapper comicViewModelMapper;

    public ComicsPresenter(ComicContract.View view, UseCaseWithParam<Integer, List<Comic>> comicUseCase, ComicViewModelMapper comicViewModelMapper) {
        this.view = view;
        this.comicUseCase = comicUseCase;
        this.comicViewModelMapper = comicViewModelMapper;
    }

    @Override
    public void getComics(int offset) {
        comicUseCase.execute(offset, getComicCallback());
    }

    private RequestCallback<List<Comic>> getComicCallback() {
        return new RequestCallback<List<Comic>>() {
            @Override
            public void onSuccess(List<Comic> value) {
                view.renderComics(comicViewModelMapper.mapToComicViewModel(value));
            }

            @Override
            public void onError(Throwable throwable) {
                view.alertErrorMessage();
            }
        };
    }
}
