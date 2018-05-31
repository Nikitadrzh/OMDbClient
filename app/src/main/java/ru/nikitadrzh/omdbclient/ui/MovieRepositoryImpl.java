package ru.nikitadrzh.omdbclient.ui;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import ru.nikitadrzh.domain.model.Movie;
import ru.nikitadrzh.domain.repository.MovieRepository;

//todo этот класс в модуле data будет, пока просто для теста тут
public class MovieRepositoryImpl implements MovieRepository {
    @Override
    public Single<List<Movie>> findMovies(String movieTitle) {

        //todo это протсо заглушка, мы не ходим в БД или сеть, а просто выдаем титл и все!
        Movie movie = new Movie(movieTitle, null, null, null, true);
        List<Movie> list = new ArrayList<>();
        list.add(movie);
        return Single.just(list);
    }
}
