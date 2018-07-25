package com.example.luka.comicsapp.di.module;

import com.example.data.networking.ComicService;
import com.example.luka.comicsapp.di.DaggerConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkingModule {

    private static final String DATE_FORMAT = "yyyy-MM-dd' 'HH:mm:ss";
    private static final String BASE_URL = "https://comicvine.gamespot.com/";

    @Provides
    @Singleton
    public HttpLoggingInterceptor provideLoggingInterceptor() {
       return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    public OkHttpClient provideClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    @Singleton
    public @Named(DaggerConstants.DATE) String provideDateFormat() {
        return DATE_FORMAT;
    }

    @Provides
    @Singleton
    public Gson provideGson(@Named(DaggerConstants.DATE) String dateFormat) {
        return new GsonBuilder()
                .setDateFormat(dateFormat)
                .create();
    }

    @Provides
    @Singleton
    public GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    public @Named(DaggerConstants.BASE) String provideBase() {
        return BASE_URL;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(@Named(DaggerConstants.BASE) String baseURL, OkHttpClient client, GsonConverterFactory factory) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(factory)
                .build();
    }

    @Provides
    @Singleton
    public ComicService provideService(Retrofit retrofit) {
        return retrofit.create(ComicService.class);
    }
}
