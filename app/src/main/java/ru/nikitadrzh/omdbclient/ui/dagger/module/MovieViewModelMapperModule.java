package ru.nikitadrzh.omdbclient.ui.dagger.module;

import dagger.Module;
import dagger.Provides;
import ru.nikitadrzh.omdbclient.ui.mapper.MovieViewModelMapper;
import ru.nikitadrzh.omdbclient.ui.mapper.MovieViewModelMapperImpl;

@Module
public class MovieViewModelMapperModule {

    @Provides
    public MovieViewModelMapper getMovieViewModelMapper() {
        return new MovieViewModelMapperImpl();
    }
}
