package com.example.luka.comicsapp.di;

import com.example.data.ComicRepositoryImpl;
import com.example.data.mappers.ComicDetailsMapper;
import com.example.data.mappers.ComicMapper;
import com.example.data.networking.ComicService;
import com.example.domain.model.Comic;
import com.example.domain.model.ComicDetails;
import com.example.domain.repository.ComicRepository;
import com.example.domain.usecase.GetComicsUseCase;
import com.example.domain.usecase.ShowComicDetailsUseCase;
import com.example.domain.usecase.UseCaseWithParam;
import com.example.luka.comicsapp.ui.comicdetails.ComicDetailsContract;
import com.example.luka.comicsapp.ui.comicdetails.ComicDetailsPresenter;
import com.example.luka.comicsapp.ui.comics.ComicContract;
import com.example.luka.comicsapp.ui.comics.ComicsPresenter;
import com.example.luka.comicsapp.ui.mappers.ComicDetailsViewModelMapper;
import com.example.luka.comicsapp.ui.mappers.ComicViewModelMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ObjectGraph {

    private static ObjectGraph instance;

    private static ComicService comicService;
    private static ComicRepository comicRepository;

    private static ComicMapper comicMapper;
    private static ComicDetailsMapper comicDetailsMapper;

    private static ComicViewModelMapper comicViewModelMapper;
    private static ComicDetailsViewModelMapper comicDetailsViewModelMapper;

    private static UseCaseWithParam<Integer, List<Comic>> comicsUseCase;
    private static UseCaseWithParam<String, ComicDetails> useCase;

    private static final String BASE_URL = "https://comicvine.gamespot.com/";
    private static final String DATE_FORMAT = "yyyy-MM-dd' 'HH:mm:ss";

    private ObjectGraph() {
    }

    public static ObjectGraph getInstance() {
        if (instance == null) {
            instance = new ObjectGraph();
        }

        return instance;
    }

    public void initialize() {
        comicMapper = new ComicMapper();
        comicViewModelMapper = new ComicViewModelMapper();

        comicDetailsMapper = new ComicDetailsMapper();
        comicDetailsViewModelMapper = new ComicDetailsViewModelMapper();

        OkHttpClient client = createClient();

        Retrofit retrofit = createRetrofit(client);

        comicService = retrofit.create(ComicService.class);
        comicRepository = new ComicRepositoryImpl(comicService, comicMapper, comicDetailsMapper);


        comicsUseCase = new GetComicsUseCase(comicRepository);
        useCase = new ShowComicDetailsUseCase(comicRepository);
    }

    private Retrofit createRetrofit(OkHttpClient client) {
        Gson gson = new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .create();

        return new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();
    }


    private OkHttpClient createClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }

    public ComicContract.Presenter getComicPresenter(ComicContract.View view) {
        return new ComicsPresenter(view, comicsUseCase, comicViewModelMapper);
    }

    public ComicDetailsContract.Presenter getComicDetailsPresenter(ComicDetailsContract.View view) {
        return new ComicDetailsPresenter(view, useCase, comicDetailsViewModelMapper);
    }
}
