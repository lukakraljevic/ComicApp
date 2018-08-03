package com.example.data.apimodel.comic;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public final class ComicApiModel {

    public final int id;
    @SerializedName("api_detail_url")
    public final String apiDetailUrl;
    @SerializedName("air_date")
    public final Date airDate;
    @SerializedName("date_added")
    public final Date dateAdded;
    public final String description;
    public final ComicImageModel image;
    public final String name;
    @SerializedName("date_last_updated")
    public final Date dateLastUpdated;
    @SerializedName("episode_number")
    public final int episodeNumber;
    @SerializedName("series")
    public final ComicSeriesApiModel comicSeries;

    public ComicApiModel(int id, String apiDetailUrl, Date airDate, Date dateAdded, String description, ComicImageModel image, String name, Date dateLastUpdated, int episodeNumber, ComicSeriesApiModel comicSeries) {
        this.id = id;
        this.apiDetailUrl = apiDetailUrl;
        this.airDate = airDate;
        this.dateAdded = dateAdded;
        this.description = description;
        this.image = image;
        this.name = name;
        this.dateLastUpdated = dateLastUpdated;
        this.episodeNumber = episodeNumber;
        this.comicSeries = comicSeries;
    }
}
