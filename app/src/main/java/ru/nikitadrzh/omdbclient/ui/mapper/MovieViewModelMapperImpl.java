package ru.nikitadrzh.omdbclient.ui.mapper;

import java.util.ArrayList;
import java.util.List;

import ru.nikitadrzh.domain.model.Movie;
import ru.nikitadrzh.omdbclient.ui.model.MovieViewModel;

public class MovieViewModelMapperImpl implements MovieViewModelMapper {
    @Override
    public List<MovieViewModel> mapMovieToViewModel(List<Movie> moviesToMap) {
        //todo пока ваще нече не меняем
        List<MovieViewModel> movieViewModels = new ArrayList<>();
        for (Movie movie : moviesToMap) {
            movieViewModels.add(new MovieViewModel("ыы", null, null, null,
                    false));
        }
        return movieViewModels;
    }
}
