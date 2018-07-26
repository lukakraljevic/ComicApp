package com.example.luka.comicsapp.di;

import com.example.luka.comicsapp.App;
import com.example.luka.comicsapp.di.activity.ActivityComponent;
import com.example.luka.comicsapp.di.activity.DaggerActivity;
import com.example.luka.comicsapp.di.application.ApplicationComponent;
import com.example.luka.comicsapp.di.fragment.DaggerFragment;
import com.example.luka.comicsapp.di.fragment.FragmentComponent;

public final class ComponentFactory {

    private ComponentFactory() {
    }

    public static ApplicationComponent createApplicationComponent(final App app) {
        return ApplicationComponent.Initializer.init(app);
    }

    public static ActivityComponent createActivityComponent(final DaggerActivity daggerActivity) {
        return ActivityComponent.Initializer.init(daggerActivity, App.getComponent());
    }

    public static FragmentComponent createFragmentComponent(final DaggerFragment daggerFragment, final ActivityComponent activityComponent) {
        return FragmentComponent.Initializer.init(daggerFragment, activityComponent);
    }
}