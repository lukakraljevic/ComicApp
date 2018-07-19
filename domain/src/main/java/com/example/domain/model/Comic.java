package com.example.domain.model;

import java.util.Date;

public class Comic {

    public final int id;

    public final String apiDetailUrl;

    public final Date airDate;

    public final String description;

    public final String name;

    public final String thumbnailUrl;

    public Comic(int id, String apiDetailUrl, Date airDate, String description, String name, String thumbnailUrl) {
        this.id = id;
        this.apiDetailUrl = apiDetailUrl;
        this.airDate = airDate;
        this.description = description;
        this.name = name;
        this.thumbnailUrl = thumbnailUrl;
    }
}
