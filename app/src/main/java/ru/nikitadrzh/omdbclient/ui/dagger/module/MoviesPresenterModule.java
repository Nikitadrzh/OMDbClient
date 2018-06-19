package ru.nikitadrzh.omdbclient.ui.dagger.module;

import dagger.Module;
import dagger.Provides;
import ru.nikitadrzh.omdbclient.ui.movie.list.MoviesFragment;
import ru.nikitadrzh.omdbclient.ui.movie.list.MoviesPresenter;

@Module
public class MoviesPresenterModule {

    private MoviesFragment fragment;

    public MoviesPresenterModule(MoviesFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    public MoviesPresenter getMoviesPresenter(MoviesFragment fragment) {
        return new MoviesPresenter(fragment);
    }
}
