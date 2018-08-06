package com.example.domain.model;

public final class ComicSearchParam {

    public final String query;
    public final int page;

    public ComicSearchParam(String query, int page) {
        this.query = query;
        this.page = page;
    }
}
