package com.example.data.apimodel.comic;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class ComicResponse {

    @SerializedName("results")
    public final List<ComicApiModel> comics;

    public ComicResponse(List<ComicApiModel> comics) {
        this.comics = comics;
    }
}
