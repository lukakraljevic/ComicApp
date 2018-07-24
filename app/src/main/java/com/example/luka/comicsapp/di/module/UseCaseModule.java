package com.example.luka.comicsapp.di.module;

import com.example.domain.model.Comic;
import com.example.domain.model.ComicDetails;
import com.example.domain.usecase.GetComicsUseCase;
import com.example.domain.usecase.ShowComicDetailsUseCase;
import com.example.domain.usecase.UseCaseWithParam;

import java.util.List;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class UseCaseModule {

    @Binds
    @Singleton
    public abstract UseCaseWithParam<Integer,List<Comic>> provideComicsUseCase(GetComicsUseCase useCase);

    @Binds
    @Singleton
    public abstract UseCaseWithParam<String, ComicDetails> provideComicDetailsUseCase(ShowComicDetailsUseCase useCase);
}
