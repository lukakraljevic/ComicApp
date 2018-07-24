package com.example.data.apimodel.comicdetails;

import com.google.gson.annotations.SerializedName;

public final class ComicCharacterApiModel {

    public final int id;
    public final String name;
    @SerializedName("site_detail_url")
    public final String siteDetailUrl;

    public ComicCharacterApiModel(int id, String name, String siteDetailUrl) {
        this.id = id;
        this.name = name;
        this.siteDetailUrl = siteDetailUrl;
    }
}
