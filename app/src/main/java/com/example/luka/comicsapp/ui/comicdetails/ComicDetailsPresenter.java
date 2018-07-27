package com.example.luka.comicsapp.ui.comicdetails;

import com.example.domain.model.ComicDetails;
import com.example.domain.usecase.GetComicDetailsUseCase;
import com.example.domain.usecase.UseCaseWithParam;
import com.example.luka.comicsapp.base.BasePresenter;
import com.example.luka.comicsapp.ui.mappers.ComicDetailsViewModelMapper;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;

public final class ComicDetailsPresenter extends BasePresenter<ComicDetailsContract.View> implements ComicDetailsContract.Presenter {

    private final UseCaseWithParam<String, ComicDetails> comicDetailsUseCase;
    private final ComicDetailsViewModelMapper comicDetailsViewModelMapper;

    @Inject
    public ComicDetailsPresenter(GetComicDetailsUseCase comicDetailsUseCase,
                                 ComicDetailsViewModelMapper comicDetailsViewModelMapper) {
        this.comicDetailsUseCase = comicDetailsUseCase;
        this.comicDetailsViewModelMapper = comicDetailsViewModelMapper;
    }


    @Override
    public void getComicDetails(String url) {
        comicDetailsUseCase.execute(url).observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(final ComicDetails value) {
        view.showComicDetails(comicDetailsViewModelMapper.mapToComicDetailsViewModel(value));
    }

    private void onError(final Throwable error) {
        view.alertErrorMessage();
    }
}