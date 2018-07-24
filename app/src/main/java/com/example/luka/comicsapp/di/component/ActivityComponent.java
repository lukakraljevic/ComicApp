package com.example.luka.comicsapp.di.component;

import android.support.v7.app.AppCompatActivity;

import com.example.luka.comicsapp.di.module.MappersModule;
import com.example.luka.comicsapp.di.module.PresentingModule;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {PresentingModule.class, MappersModule.class})
public interface ActivityComponent extends ActivityComponentInjects {

    @Subcomponent.Builder
    interface Builder {

        Builder presentingModule(PresentingModule presentingModule);

        Builder mappersModule(MappersModule mappersModule);

        ActivityComponent build();
    }

    final class Initializer {

        static public ActivityComponent init(final AppCompatActivity daggerActivity, final ApplicationComponent applicationComponent) {
            return applicationComponent.activityComponentBuilder()
                    .presentingModule(new PresentingModule(daggerActivity))
                    .mappersModule(new MappersModule())
                    .build();
        }

        private Initializer() {
        }
    }
}