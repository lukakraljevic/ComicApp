package com.example.luka.comicsapp.di.activity;

import com.example.luka.comicsapp.di.application.ApplicationComponent;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class, ActivityPresenterModule.class})
public interface ActivityComponent extends ActivityComponentInjects {

    @Subcomponent.Builder
    interface Builder {

        Builder activityModule(ActivityModule activityModule);

        ActivityComponent build();
    }

    final class Initializer {

        static public ActivityComponent init(final DaggerActivity daggerActivity, final ApplicationComponent applicationComponent) {
            return applicationComponent.activityComponentBuilder()
                    .activityModule(new ActivityModule(daggerActivity))
                    .build();
        }

        private Initializer() {
        }
    }
}