package com.example.luka.comicsapp.di.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.luka.comicsapp.di.ComponentFactory;

public abstract class DaggerActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        inject(getActivityComponent());
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = ComponentFactory.createActivityComponent(this);
        }

        return activityComponent;
    }

    protected abstract void inject(final ActivityComponent activityComponent);
}
