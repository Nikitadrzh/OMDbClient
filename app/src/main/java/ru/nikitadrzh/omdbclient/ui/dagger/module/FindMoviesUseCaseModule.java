package ru.nikitadrzh.omdbclient.ui.dagger.module;

import dagger.Module;
import dagger.Provides;
import ru.nikitadrzh.data.movie.MovieRepositoryImpl;
import ru.nikitadrzh.data.movie.service.MoviesService;
import ru.nikitadrzh.data.movie.service.MoviesServiceConverter;
import ru.nikitadrzh.domain.interactor.movie.FindMoviesUseCase;
import ru.nikitadrzh.domain.repository.MovieRepository;

@Module(includes = ServiceModule.class)
public class FindMoviesUseCaseModule {

    @Provides
    public FindMoviesUseCase getFindMoviesUseCase(MovieRepository repository) {
        return new FindMoviesUseCase(repository);
    }

    @Provides
    public MovieRepository getMovieRepository(MoviesService service,
                                              MoviesServiceConverter converter) {
        return new MovieRepositoryImpl(service, converter);
    }
}
