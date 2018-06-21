package ru.nikitadrzh.omdbclient.ui.dagger;

import dagger.Component;
import ru.nikitadrzh.omdbclient.ui.dagger.module.FindMoviesUseCaseModule;
import ru.nikitadrzh.omdbclient.ui.dagger.module.MovieViewModelMapperModule;
import ru.nikitadrzh.omdbclient.ui.dagger.module.MoviesFragmentModule;
import ru.nikitadrzh.omdbclient.ui.dagger.module.MoviesPresenterModule;
import ru.nikitadrzh.omdbclient.ui.movie.content.MovieFragment;
import ru.nikitadrzh.omdbclient.ui.movie.list.MoviesFragment;
import ru.nikitadrzh.omdbclient.ui.movie.list.MoviesPresenter;

@Component(modules = {FindMoviesUseCaseModule.class, MoviesPresenterModule.class,
        MovieViewModelMapperModule.class},
        dependencies = ActivityComponent.class)
public interface FragmentComponent {
    void injectTo(MoviesFragment fragment);
    void injectTo(MoviesPresenter presenter);
}
