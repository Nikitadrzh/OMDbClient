package ru.nikitadrzh.omdbclient.ui.dagger;

import dagger.Component;
import ru.nikitadrzh.omdbclient.MainActivity;
import ru.nikitadrzh.omdbclient.ui.dagger.module.FindMoviesUseCaseModule;
import ru.nikitadrzh.omdbclient.ui.dagger.module.MovieViewModelMapperModule;
import ru.nikitadrzh.omdbclient.ui.dagger.module.MoviesFragmentModule;
import ru.nikitadrzh.omdbclient.ui.dagger.module.MoviesPresenterModule;
import ru.nikitadrzh.omdbclient.ui.dagger.module.PagerAdapterModule;
import ru.nikitadrzh.omdbclient.ui.movie.list.MoviesPresenter;

@Component(modules = {PagerAdapterModule.class, MoviesFragmentModule.class})
public interface ActivityComponent {
    void injectTo(MainActivity activity);
}
