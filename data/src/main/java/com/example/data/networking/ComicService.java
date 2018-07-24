package com.example.data.networking;

import com.example.data.apimodel.comic.ComicResponse;
import com.example.data.apimodel.comicdetails.ComicDetailsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ComicService {

    @GET("/api/episodes")
    Call<ComicResponse> getComics(@Query("api_key") String apiKey, @Query("format") String format, @Query("limit") int limit,
                                  @Query("offset") int offset);

    @GET("/api/episode/{id}")
    Call<ComicDetailsResponse> getComicDetails(@Path("id") String id, @Query("api_key") String apiKey, @Query("format") String format);
}
