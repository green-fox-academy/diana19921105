package com.greenfox.springadvanced.service;

import com.greenfox.springadvanced.model.Genres;
import com.greenfox.springadvanced.model.Movie;
import com.greenfox.springadvanced.model.MovieServiceGenerator;

import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

import java.util.List;


@Service
public class MovieService {
    private MovieApiService movieApiService = MovieServiceGenerator.createService(MovieApiService.class);
    private String apiKey = System.getenv("API_KEY");


    public Movie showMovieById(Long id) throws IOException {
        Call<Movie> movieCall = movieApiService.getMovieById(id, apiKey);
        return movieCall.execute().body();
    }

    public List<Movie> getAllMovies() throws IOException {
        Call<List<Movie>> movieList = movieApiService.getAllMovies(apiKey);
        Response<List<Movie>> response = movieList.execute();
        return response.body();
    }

    public Genres callGenres() throws IOException {
        Call<Genres> call = movieApiService.getAllGenre(apiKey);

        Response<Genres> response = call.execute();
        return response.body();
    }
}
