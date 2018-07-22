package com.example.data.apimodel.comicdetails;

import com.example.data.apimodel.comic.ComicImageModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class ComicDetailsApiModel {

    public final int id;
    public final String description;
    public final ComicImageModel image;
    public final String name;
    @SerializedName("character_credits")
    public final List<ComicCharacterApiModel> charachters;

    public ComicDetailsApiModel(int id, String description, ComicImageModel image, String name, List<ComicCharacterApiModel> charachters) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.name = name;
        this.charachters = charachters;
    }
}
