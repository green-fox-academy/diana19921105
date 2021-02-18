package com.greenfox.springadvanced.service;

import com.greenfox.springadvanced.model.GenreDto;
import com.greenfox.springadvanced.model.GenresListDto;
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

    public GenresListDto callGenres() throws IOException {
        Call<GenresListDto> call = movieApiService.getAllGenre(apiKey);

        Response<GenresListDto> response = call.execute();
        return response.body();
    }
}
