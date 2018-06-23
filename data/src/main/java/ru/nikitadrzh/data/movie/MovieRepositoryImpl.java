package ru.nikitadrzh.data.movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import ru.nikitadrzh.data.movie.service.MoviesService;
import ru.nikitadrzh.data.movie.service.MoviesServiceConverter;
import ru.nikitadrzh.data.movie.service.model.MoviesServiceModel;
import ru.nikitadrzh.data.movie.service.model.Search;
import ru.nikitadrzh.domain.model.Movie;
import ru.nikitadrzh.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {

    private static final String APIKEY = "79cecb30";

    private MoviesService service;
    private MoviesServiceConverter converter;

    public MovieRepositoryImpl(MoviesService service, MoviesServiceConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Override
    public Single<List<Movie>> findMovies(String movieTitle) throws IOException {

        //todo берем service и вызываем его методы, от него получаем список/observable и возвращаем
        //todo тут вроде как все в UI потоке, надо перенести на другой!!!

        return service.getMovies(APIKEY, movieTitle)
                //.subscribeOn(Schedulers.io())
                .map(serviceModel -> {
                    List<Movie> list = new ArrayList<>();
                    for (Search search : serviceModel.getSearch()) {
                        list.add(converter.modelToDomain(search));
                    }
                    return list;
                });
//                .observeOn(AndroidSchedulers.mainThread());
    }
}
