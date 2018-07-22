package com.example.domain.model;

public final class ComicCharacter {

    public final int id;
    public final String name;
    public final String siteDetailUrl;

    public ComicCharacter(int id, String name, String siteDetailUrl) {
        this.id = id;
        this.name = name;
        this.siteDetailUrl = siteDetailUrl;
    }
}
