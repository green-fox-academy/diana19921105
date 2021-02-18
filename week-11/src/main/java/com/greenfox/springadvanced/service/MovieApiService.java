package com.greenfox.springadvanced.service;

import com.greenfox.springadvanced.model.Genres;
import com.greenfox.springadvanced.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface MovieApiService {

    @GET("/movie{id}/{")
    Call<Movie> getMovieById(@Path("id") Long id,
                             @Query("api_key") String apiKey);

    @GET("/movie")
    Call<List<Movie>> getMovieByGenre(@Query("genre") String genre,
                                      @Query("api_key") String apiKey);

    @GET("/movie/list")
    Call<List<Movie>> getAllMovies(@Query("api_key") String apiKey);

    @GET("genre/movie/list")
    Call<Genres> getAllGenre (@Query("api_key") String apiKey);
}
