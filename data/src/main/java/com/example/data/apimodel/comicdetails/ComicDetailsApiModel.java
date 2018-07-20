package com.example.data.apimodel.comicdetails;

import com.example.data.apimodel.comic.ComicImageModel;

public final class ComicDetailsApiModel {

    public final int id;
    public final String description;
    public final ComicImageModel image;
    public final String name;

    public ComicDetailsApiModel(int id, String description, ComicImageModel image, String name) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.name = name;
    }
}
