package com.example.luka.comicsapp.di.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;

@Module
public final class ActivityModule {

    private final DaggerActivity daggerActivity;

    public ActivityModule(final DaggerActivity daggerActivity) {
        this.daggerActivity = daggerActivity;
    }

    @Provides
    @ActivityScope
    Context provideActivityContext() {
        return daggerActivity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity() {
        return daggerActivity;
    }

    @Provides
    @ActivityScope
    FragmentManager provideFragmentManager() {
        return daggerActivity.getSupportFragmentManager();
    }
}
