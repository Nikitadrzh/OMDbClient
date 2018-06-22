package ru.nikitadrzh.data.movie.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.nikitadrzh.data.movie.service.model.MoviesServiceModel;

public interface MoviesService {
    //todo сделать через RX адаптер
    @GET()
    Call<MoviesServiceModel> getMovies(@Query("apikey") String apiKey,
                                             @Query("s") String movieTitle);
}
