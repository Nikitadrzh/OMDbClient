package ru.nikitadrzh.omdbclient.ui.dagger.module;

import dagger.Module;
import dagger.Provides;
import ru.nikitadrzh.data.movie.MovieRepositoryImpl;
import ru.nikitadrzh.domain.interactor.movie.FindMoviesUseCase;
import ru.nikitadrzh.domain.repository.MovieRepository;

@Module
public class FindMoviesUseCaseModule {

    @Provides
    public FindMoviesUseCase getFindMoviesUseCase(MovieRepository repository) {
        return new FindMoviesUseCase(repository);
    }

    @Provides
    public MovieRepository getMovieRepository() {
        return new MovieRepositoryImpl();
    }
}
