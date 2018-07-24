package com.example.luka.comicsapp.di.component;

import com.example.luka.comicsapp.App;
import com.example.luka.comicsapp.di.module.MappersModule;
import com.example.luka.comicsapp.di.module.NetworkingModule;
import com.example.luka.comicsapp.di.module.RepositoryModule;
import com.example.luka.comicsapp.di.module.UseCaseModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkingModule.class, RepositoryModule.class, UseCaseModule.class, MappersModule.class})
public interface ApplicationComponent extends ApplicationComponentInjects {

    final class Initializer {

        static public ApplicationComponent init(final App app) {
            return DaggerApplicationComponent.builder()
                    .networkingModule(new NetworkingModule())
                    .mappersModule(new MappersModule())
                    .build();
        }

        private Initializer() {
        }
    }

    ActivityComponent.Builder activityComponentBuilder();
}