package com.example.luka.comicsapp.di.activity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public final class ThreadingModule {

    public static final String MAIN_SCHEDULER = "main";
    public static final String BACKGROUND_SCHEDULER = "background";

    @Provides
    @ActivityScope
    @Named(ThreadingModule.MAIN_SCHEDULER)
    public Scheduler provideMainScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @ActivityScope
    @Named(ThreadingModule.BACKGROUND_SCHEDULER)
    public Scheduler provideBackgroundScheduler() {
        return Schedulers.io();
    }
}
