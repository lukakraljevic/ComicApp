package com.example.domain.model;

import com.example.domain.utils.DateFormatUtils;

import java.io.Serializable;
import java.util.Date;

public final class Comic implements Serializable {

    public final int id;
    public final String apiDetailUrl;
    public final String airDate;
    public final String dateAdded;
    public final String description;
    public final String seriesName;
    public final String thumbnailUrl;
    public final String screenUrl;
    public final int episodeNumber;
    public final String dateLastUpdated;
    public final String name;

    private static final String NOT_AVAILABLE = "N/A";

    public Comic(int id, String apiDetailUrl, Date airDate, Date dateAdded, String description, String seriesName,
                 String thumbnailUrl, String screenUrl, int episodeNumber, Date dateLastUpdated, String name) {
        this.id = id;
        this.apiDetailUrl = apiDetailUrl;
        this.airDate = (airDate == null) ? NOT_AVAILABLE : DateFormatUtils.getSimpleDateFormat().format(airDate);
        this.dateAdded = (dateAdded == null) ? NOT_AVAILABLE : DateFormatUtils.getSimpleDateFormat().format(dateAdded);
        this.description = (description == null) ? "" : description;
        this.seriesName = seriesName;
        this.thumbnailUrl = thumbnailUrl;
        this.screenUrl = screenUrl;
        this.episodeNumber = episodeNumber;
        this.dateLastUpdated =  (dateLastUpdated == null) ? NOT_AVAILABLE :
                                        DateFormatUtils.getSimpleDateFormat().format(dateLastUpdated);
        this.name = name;
    }
}
