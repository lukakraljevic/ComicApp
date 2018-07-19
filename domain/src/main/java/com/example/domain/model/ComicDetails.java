package com.example.domain.model;

public class ComicDetails {

    public final int id;

    public final String description;

    public final String imageUrl;

    public final String name;

    public ComicDetails(int id, String description, String imageUrl, String name) {
        this.id = id;
        this.description = description;
        this.imageUrl = imageUrl;
        this.name = name;
    }
}
