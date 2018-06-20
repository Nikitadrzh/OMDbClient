package ru.nikitadrzh.omdbclient.ui.dagger.module;

import dagger.Module;
import dagger.Provides;
import ru.nikitadrzh.omdbclient.ui.movie.list.MoviesFragment;

@Module
public class MoviesFragmentModule {

    @Provides
    public MoviesFragment getMoviesFragment() {
        return new MoviesFragment();
    }
}
