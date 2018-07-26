package com.example.luka.comicsapp.ui.utils;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public final class ViewIdGenerator {

    @Inject
    public ViewIdGenerator() {
    }

    public String newId() {
        return UUID.randomUUID().toString();
    }
}
