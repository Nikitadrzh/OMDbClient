package ru.nikitadrzh.omdbclient.ui.movie.list;


import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ru.nikitadrzh.domain.interactor.movie.FindMoviesUseCase;
import ru.nikitadrzh.domain.repository.MovieRepository;
import ru.nikitadrzh.omdbclient.ui.mapper.MovieViewModelMapper;
import ru.nikitadrzh.omdbclient.ui.model.MovieViewModel;

/*
Данный класс - реализация презентера, который по запросу view предоставляет список фильмов, класс
реализовывает контракт, в котором прописаны функции объекта
 */
public class MoviesPresenter implements MoviesContract.Presenter {

    //в RxJava2 вместо subscription - disposable
    private Disposable disposable;

    @Inject
    private FindMoviesUseCase findMoviesUseCase;

    //todo заинджектить
    private MovieViewModelMapper movieViewModelMapper;

    /*
    По-сути сюда именно Fragment приходит, но cast под MoviesContract.View, так что впринципе
    это нормально, к примеру, мы можем легко заменить MainActivity на фрагмент, реализующий .View,
    при этом код презентера вообще не поменяется никак! Так как этого и добиваемся, то тест пройден
    */
    private MoviesContract.View view;

    public MoviesPresenter(MoviesContract.View view){
        this.view = view;
    }

    @Override
    public void findMovies(String movieTitle) {
        disposable = findMoviesUseCase.execute(movieTitle)
                .map(movieViewModelMapper::mapMovieToViewModel)//конвертируем во вьюмодель
                .subscribe(this::showFoundMovies, Throwable::printStackTrace);
    }

    private void showFoundMovies(List<MovieViewModel> foundMovies) {
        view.showMovies(foundMovies);
    }
}
