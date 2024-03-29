package com.example.data.apimodel.comic;

import com.google.gson.annotations.SerializedName;

public final class ComicImageModel {

    @SerializedName("meidum_url")
    public final String mediumUrl;
    @SerializedName("thumb_url")
    public final String thumbUrl;
    @SerializedName("screen_url")
    public final String screenUrl;
    @SerializedName("small_url")
    public final String smallUrl;
    @SerializedName("screen_large_url")
    public final String screenLargeUrl;

    public ComicImageModel(String mediumUrl, String thumbUrl, String screenUrl, String smallUrl, String screenLargeUrl) {
        this.mediumUrl = mediumUrl;
        this.thumbUrl = thumbUrl;
        this.screenUrl = screenUrl;
        this.smallUrl = smallUrl;
        this.screenLargeUrl = screenLargeUrl;
    }
}
