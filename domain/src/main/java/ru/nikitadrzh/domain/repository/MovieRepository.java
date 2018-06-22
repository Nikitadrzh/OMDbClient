package ru.nikitadrzh.domain.repository;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import ru.nikitadrzh.domain.model.Movie;

public interface MovieRepository {

    Single<List<Movie>> findMovies(String movieTitle) throws IOException;
}
