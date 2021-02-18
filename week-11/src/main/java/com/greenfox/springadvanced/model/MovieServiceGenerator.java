package com.greenfox.springadvanced.model;

import com.greenfox.springadvanced.service.SecurityService;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieServiceGenerator {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = builder.build();
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private SecurityService securityService;

    @Autowired
    public MovieServiceGenerator(SecurityService securityService) {
        this.securityService = securityService;
    }

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
