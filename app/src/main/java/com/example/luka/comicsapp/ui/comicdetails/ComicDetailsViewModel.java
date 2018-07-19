package com.example.luka.comicsapp.ui.comicdetails;


public class ComicDetailsViewModel {

    public final String description;

    public final String imageUrl;

    public final String name;

    public ComicDetailsViewModel(String description, String imageUrl, String name) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.name = name;
    }
}
