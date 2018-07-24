package com.example.luka.comicsapp.di.module;

import com.example.data.ComicRepositoryImpl;
import com.example.domain.repository.ComicRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RepositoryModule {

    @Binds
    @Singleton
    public abstract ComicRepository provideRepository(ComicRepositoryImpl comicRepository);
}
