package ru.nikitadrzh.data.movie.service;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.nikitadrzh.data.movie.service.model.MoviesServiceModel;

public interface MoviesService {
    //todo сделать через RX адаптер
    @GET(".")
    Single<MoviesServiceModel> getMovies(@Query("apikey") String apiKey,
                                         @Query("s") String movieTitle);
}
