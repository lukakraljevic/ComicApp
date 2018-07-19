package com.example.data.apimodel.comic;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ComicApiModel {

    public int id;

    @SerializedName("api_detail_url")
    public String apiDetailUrl;

    @SerializedName("air_date")
    public Date airDate;

    public String description;

    public ComicImageModel image;

    public String name;

    public ComicApiModel(int id, String apiDetailUrl, Date airDate, String description, ComicImageModel image, String name) {
        this.id = id;
        this.apiDetailUrl = apiDetailUrl;
        this.airDate = airDate;
        this.description = description;
        this.image = image;
        this.name = name;
    }
}
