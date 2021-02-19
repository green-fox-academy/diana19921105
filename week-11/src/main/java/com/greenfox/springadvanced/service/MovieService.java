package com.greenfox.springadvanced.service;

import com.greenfox.springadvanced.model.GenresListDto;
import com.greenfox.springadvanced.model.MovieDto;
import com.greenfox.springadvanced.model.MovieServiceGenerator;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class MovieService {
    private MovieApiService movieApiService = MovieServiceGenerator.createService(MovieApiService.class);
    private String apiKey = System.getenv("API_KEY");

    public MovieDto showMovieById(Integer id) throws IOException {
        Call<MovieDto> movieCall = movieApiService.getMovieById(id, apiKey);

        movieCall.enqueue(new Callback<>() {

            @Override
            public void onResponse(Call<MovieDto> call, Response<MovieDto> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.headers());
                    System.out.println(response.code());
                    System.out.println(response.body());
                    System.out.println(response.isSuccessful());

                } else {
                    System.out.println("Not successful");
                }
            }

            @Override
            public void onFailure(Call<MovieDto> call, Throwable t) {
                System.out.println(t);
            }
        });
        return movieCall.execute().body();
    }

    public GenresListDto callGenres() throws IOException {
        Call<GenresListDto> call = movieApiService.getAllGenre(apiKey);

        Response<GenresListDto> response = call.execute();
        return response.body();
    }

}
