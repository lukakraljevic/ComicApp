package com.example.luka.comicsapp.ui.comicdetails;


import com.example.domain.model.ComicCharacter;

import java.util.List;

public final class ComicDetailsViewModel {

    public final String description;
    public final String imageUrl;
    public final String name;
    public final List<ComicCharacter> characters;

    public ComicDetailsViewModel(String description, String imageUrl, String name, List<ComicCharacter> characters) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.name = name;
        this.characters = characters;
    }
}
