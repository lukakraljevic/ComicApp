package com.example.luka.comicsapp.di.fragment;

import dagger.Module;

@Module
public class FragmentModule {

    private final DaggerFragment fragment;

    public FragmentModule(final DaggerFragment fragment) {
        this.fragment = fragment;
    }
}
