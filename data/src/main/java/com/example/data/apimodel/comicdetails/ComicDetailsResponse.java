package com.example.data.apimodel.comicdetails;

import com.google.gson.annotations.SerializedName;

public final class ComicDetailsResponse {

    @SerializedName("results")
    public final ComicDetailsApiModel comicDetails;

    public ComicDetailsResponse(ComicDetailsApiModel comicDetails) {
        this.comicDetails = comicDetails;
    }
}
