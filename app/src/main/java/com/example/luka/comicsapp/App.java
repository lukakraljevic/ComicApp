package com.example.luka.comicsapp;

import android.app.Application;

import com.example.luka.comicsapp.di.ObjectGraph;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ObjectGraph.getInstance().initialize();
    }
}
