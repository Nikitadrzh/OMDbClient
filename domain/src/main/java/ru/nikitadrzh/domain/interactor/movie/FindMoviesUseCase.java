package ru.nikitadrzh.domain.interactor.movie;

import java.io.IOException;
import java.util.List;

import io.reactivex.Single;
import ru.nikitadrzh.domain.interactor.type.SingleUseCaseWithParameter;
import ru.nikitadrzh.domain.model.Movie;
import ru.nikitadrzh.domain.repository.MovieRepository;

//получение фильма из репозитория
public class FindMoviesUseCase implements SingleUseCaseWithParameter<String, List<Movie>> {
    private final MovieRepository movieRepository;

    public FindMoviesUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Single<List<Movie>> execute(String movieTitle) throws IOException {
        return movieRepository.findMovies(movieTitle);
    }
}
