package com.example.domain.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class Comic implements Serializable {

    public final int id;
    public final String apiDetailUrl;
    public final String airDate;
    public final String description;
    public final String name;
    public final String thumbnailUrl;
    public final String screenUrl;
    public final int episodeNumber;
    public final String dateLastUpdated;

    public static final String DATE_PATTERN = "dd.MM.yyyy.";
    public static final String NOT_AVAILABLE = "N/A";

    public Comic(int id, String apiDetailUrl, Date airDate, String description, String name,
                 String thumbnailUrl, String screenUrl, int episodeNumber, Date dateLastUpdated) {
        this.id = id;
        this.apiDetailUrl = apiDetailUrl;
        this.airDate = (airDate == null) ? NOT_AVAILABLE :
                                            new SimpleDateFormat(DATE_PATTERN, Locale.getDefault()).format(airDate);
        this.description = (description == null) ? "" : description;
        this.name = name;
        this.thumbnailUrl = thumbnailUrl;
        this.screenUrl = screenUrl;
        this.episodeNumber = episodeNumber;
        this.dateLastUpdated = (dateLastUpdated == null) ? NOT_AVAILABLE :
                new SimpleDateFormat(DATE_PATTERN, Locale.getDefault()).format(dateLastUpdated);
    }
}
