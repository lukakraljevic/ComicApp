package com.example.luka.comicsapp.di.module;

import android.support.v7.app.AppCompatActivity;

import com.example.luka.comicsapp.App;
import com.example.luka.comicsapp.di.component.ActivityComponent;
import com.example.luka.comicsapp.di.component.ApplicationComponent;

public final class ComponentFactory {

    private ComponentFactory() {
    }

    public static ApplicationComponent createApplicationComponent(final App app) {
        return ApplicationComponent.Initializer.init(app);
    }

    public static ActivityComponent createActivityComponent(final AppCompatActivity daggerActivity) {
        return ActivityComponent.Initializer.init(daggerActivity, App.getComponent());
    }
}