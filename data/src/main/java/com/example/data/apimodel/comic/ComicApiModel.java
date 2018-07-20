package com.example.data.apimodel.comic;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public final class ComicApiModel {

    public final int id;
    @SerializedName("api_detail_url")
    public final String apiDetailUrl;
    @SerializedName("air_date")
    public final Date airDate;
    public final String description;
    public final ComicImageModel image;
    public final String name;

    public ComicApiModel(int id, String apiDetailUrl, Date airDate, String description, ComicImageModel image, String name) {
        this.id = id;
        this.apiDetailUrl = apiDetailUrl;
        this.airDate = airDate;
        this.description = description;
        this.image = image;
        this.name = name;
    }
}
