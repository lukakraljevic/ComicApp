package com.example.domain.model;

import java.util.Date;

public class Comic {

    public int id;

    public String apiDetailUrl;

    public Date airDate;

    public String description;

    public String name;

    public String thumbnailUrl;

    public Comic(int id, String apiDetailUrl, Date airDate, String description, String name, String thumbnailUrl) {
        this.id = id;
        this.apiDetailUrl = apiDetailUrl;
        this.airDate = airDate;
        this.description = description;
        this.name = name;
        this.thumbnailUrl = thumbnailUrl;
    }
}
