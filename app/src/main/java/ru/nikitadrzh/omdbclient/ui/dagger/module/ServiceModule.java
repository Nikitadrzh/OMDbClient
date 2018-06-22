package ru.nikitadrzh.omdbclient.ui.dagger.module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.nikitadrzh.data.movie.service.MoviesService;
import ru.nikitadrzh.data.movie.service.MoviesServiceConverter;

@Module
public class ServiceModule {

    @Provides
    public MoviesService getService(Retrofit retrofit) {
        return retrofit.create(MoviesService.class);
    }

    @Provides
    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public MoviesServiceConverter getServiceConverter() {
        return new MoviesServiceConverter();
    }
}
