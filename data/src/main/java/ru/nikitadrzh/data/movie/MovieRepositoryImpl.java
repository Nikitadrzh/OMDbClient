package ru.nikitadrzh.data.movie;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import ru.nikitadrzh.domain.model.Movie;
import ru.nikitadrzh.domain.repository.MovieRepository;

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
