package com.example.luka.comicsapp.ui.utils;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLoader {

    public static void loadImage(String imagePath, ImageView targetView) {
        Picasso.get().load(imagePath).into(targetView);
    }

    public static void loadImage(String imagePath, ImageView targetView, int placeholder) {
        Picasso.get().load(imagePath).placeholder(placeholder).into(targetView);
    }
}
