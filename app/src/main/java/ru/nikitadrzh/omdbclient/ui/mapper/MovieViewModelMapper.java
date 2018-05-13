package ru.nikitadrzh.omdbclient.ui.mapper;

import java.util.List;

import ru.nikitadrzh.domain.model.Movie;
import ru.nikitadrzh.omdbclient.ui.model.MovieViewModel;

//интерфейс маппера, который преобразует Movie -> MovieViewModel
public interface MovieViewModelMapper {

    //todo метод надо потом реализовать, также тут в mapper
    List<MovieViewModel> mapMovieToViewModel(List<Movie> moviesToMap);
}
