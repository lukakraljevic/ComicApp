package com.example.luka.comicsapp;

import android.app.Application;

import com.example.luka.comicsapp.di.component.ApplicationComponent;
import com.example.luka.comicsapp.di.component.ComponentFactory;


public class App extends Application {

    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = ComponentFactory.createApplicationComponent(this);
    }

    public static ApplicationComponent getComponent() {
        return component;
    }
}
