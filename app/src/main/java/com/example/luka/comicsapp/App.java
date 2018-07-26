package com.example.luka.comicsapp;

import android.app.Application;
import android.content.Context;

import com.example.luka.comicsapp.di.application.ApplicationComponent;
import com.example.luka.comicsapp.di.ComponentFactory;


public class App extends Application {

    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = ComponentFactory.createApplicationComponent(this);
    }

    public static App from(final Context context) {
        return (App) context.getApplicationContext();
    }

    public static ApplicationComponent getComponent() {
        return component;
    }
}
