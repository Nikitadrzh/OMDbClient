package ru.nikitadrzh.data.movie.service;

import ru.nikitadrzh.data.movie.service.model.Search;
import ru.nikitadrzh.domain.model.Movie;

public class MoviesServiceConverter {

    public Movie modelToDomain(Search search) {
        return new Movie(search.getTitle(),
                search.getType(),
                search.getYear(),
                search.getPoster(),
                false);
    }
}
