package com.example.luka.comicsapp.di.component;

import com.example.luka.comicsapp.App;
import com.example.luka.comicsapp.di.module.NetworkingModule;
import com.example.luka.comicsapp.di.module.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkingModule.class, RepositoryModule.class})
public interface ApplicationComponent extends ApplicationComponentInjects {

    final class Initializer {

        static public ApplicationComponent init(final App app) {
            return DaggerApplicationComponent.builder()
                    .build();
        }

        private Initializer() {
        }
    }

    ActivityComponent.Builder activityComponentBuilder();
}