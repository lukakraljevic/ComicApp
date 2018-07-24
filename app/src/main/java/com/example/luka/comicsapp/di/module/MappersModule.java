package com.example.luka.comicsapp.di.module;

import com.example.data.mappers.ComicDetailsMapper;
import com.example.data.mappers.ComicMapper;
import com.example.luka.comicsapp.di.component.ActivityScope;
import com.example.luka.comicsapp.ui.mappers.ComicDetailsViewModelMapper;
import com.example.luka.comicsapp.ui.mappers.ComicViewModelMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MappersModule {

    @Provides
    @Singleton
    public ComicMapper provideComicMapper() {
        return new ComicMapper();
    }

    @Provides
    @Singleton
    public ComicDetailsMapper provideComicDetailsMapper() {
        return new ComicDetailsMapper();
    }

    @Provides
    @ActivityScope
    public ComicViewModelMapper provideComicViewModelMapper() {
        return new ComicViewModelMapper();
    }

    @Provides
    @ActivityScope
    public ComicDetailsViewModelMapper provideComicDetailsViewModeMapper() {
        return new ComicDetailsViewModelMapper();
    }
}
