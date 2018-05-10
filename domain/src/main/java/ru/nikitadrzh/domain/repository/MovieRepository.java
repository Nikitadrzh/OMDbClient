package ru.nikitadrzh.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import ru.nikitadrzh.domain.model.Movie;

public interface MovieRepository {
    Observable<List<Movie>> findMovies(String movieTitle);
}
