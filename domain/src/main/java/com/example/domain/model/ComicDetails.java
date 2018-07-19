package com.example.domain.model;

public class ComicDetails {

    public int id;

    public String description;

    public String imageUrl;

    public String name;

    public ComicDetails(int id, String description, String imageUrl, String name) {
        this.id = id;
        this.description = description;
        this.imageUrl = imageUrl;
        this.name = name;
    }
}
