package com.greenfox.springadvanced.service;

import com.greenfox.springadvanced.model.GenresListDto;
import com.greenfox.springadvanced.model.Movie;
import com.greenfox.springadvanced.model.MovieDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface MovieApiService {

    @GET("movie/{movie_id}")
    Call<MovieDto> getMovieById(@Path("movie_id") Integer id,
                                @Query("api_key") String apiKey);


    @GET("genre/movie/list")
    Call<GenresListDto> getAllGenre (@Query("api_key") String apiKey);
}
