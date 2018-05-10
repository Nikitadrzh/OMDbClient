package ru.nikitadrzh.domain.interactor.movie;

import java.util.List;

import io.reactivex.Observable;
import ru.nikitadrzh.domain.interactor.type.UseCaseWithParameters;
import ru.nikitadrzh.domain.model.Movie;
import ru.nikitadrzh.domain.repository.MovieRepository;

//получение фильма из репозитория
public class FindMoviesUseCase implements UseCaseWithParameters<String, List<Movie>> {
    private final MovieRepository movieRepository;

    //Интерфейс MovieRepository реализовывается во внешнем слое - модуле data
    public FindMoviesUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Observable<List<Movie>> execute(String movieTitle) {
        return movieRepository.findMovies(movieTitle);
    }
}
