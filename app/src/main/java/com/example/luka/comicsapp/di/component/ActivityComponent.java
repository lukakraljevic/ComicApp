package com.example.luka.comicsapp.di.component;

import com.example.luka.comicsapp.di.module.PresentationModule;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {PresentationModule.class})
public interface ActivityComponent extends ActivityComponentInjects {

    @Subcomponent.Builder
    interface Builder {

        ActivityComponent build();
    }

    final class Initializer {

        static public ActivityComponent init(final ApplicationComponent applicationComponent) {
            return applicationComponent.activityComponentBuilder()
                    .build();
        }

        private Initializer() {
        }
    }
}