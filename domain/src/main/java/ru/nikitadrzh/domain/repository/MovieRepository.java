package ru.nikitadrzh.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import ru.nikitadrzh.domain.model.Movie;

public interface MovieRepository {
//    Observable<List<Movie>> findMovies(String movieTitle);
    //todo поменяем на single (потом отдельный класс сделать)
    Single<List<Movie>> findMovies(String movieTitle);

}
