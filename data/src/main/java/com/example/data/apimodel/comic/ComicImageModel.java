package com.example.data.apimodel.comic;

import com.google.gson.annotations.SerializedName;

public class ComicImageModel {

    @SerializedName("meidum_url")
    public String mediumUrl;

    @SerializedName("thumb_url")
    public String thumbUrl;

    @SerializedName("screen_url")
    public String screenUrl;

    @SerializedName("small_url")
    public String smallUrl;

}
