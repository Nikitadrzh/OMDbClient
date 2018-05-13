package ru.nikitadrzh.omdbclient.ui.movie.list;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import ru.nikitadrzh.domain.interactor.movie.FindMoviesUseCase;
import ru.nikitadrzh.domain.model.Movie;
import ru.nikitadrzh.omdbclient.ui.mapper.MovieViewModelMapper;
import ru.nikitadrzh.omdbclient.ui.model.MovieViewModel;

/*
Данный класс - реализация презентера, который по запросу view предоставляет список фильмов, класс
реализовывает контракт, в котором прописаны функции объекта
 */
public class MoviesPresenter implements MoviesContract.Presenter {

    private Subscription subscription;

    //todo заинджектить
    private FindMoviesUseCase findMoviesUseCase;

    //todo заинджектить
    private MovieViewModelMapper movieViewModelMapper;

    @Override
    public void findMovies(String movieTitle) {
        subscription = findMoviesUseCase.execute(movieTitle)
                .map(movieViewModelMapper::mapMovieToViewModel); //конвертируем во вьюмодель
//                .subscribe(this::showFoundMovies, Throwable::printStackTrace);
    }

    private void showFoundMovies(List<MovieViewModel> foundMovies) {

    }
}
