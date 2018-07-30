package com.example.domain.model;

import java.util.Collections;
import java.util.List;

public final class ComicDetails {

    public final int id;
    public final String description;
    public final String imageUrl;
    public final String name;
    public final List<ComicCharacter> characters;
    public static final ComicDetails EMPTY = new ComicDetails(-1, "", "",
            "", Collections.<ComicCharacter>emptyList());

    public ComicDetails(int id, String description, String imageUrl, String name, List<ComicCharacter> characters) {
        this.id = id;
        this.description = description;
        this.imageUrl = imageUrl;
        this.name = name;
        this.characters = characters;
    }
}
