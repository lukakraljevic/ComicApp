package com.example.data.apimodel.comicdetails;

import com.example.data.apimodel.comic.ComicImageModel;

public class ComicDetailsApiModel {

    public int id;
    public String description;
    public ComicImageModel image;
    public String name;

    public ComicDetailsApiModel(int id, String description, ComicImageModel image, String name) {
        this.id = id;
        this.description = description;
        this.image = image;
        this.name = name;
    }
}
