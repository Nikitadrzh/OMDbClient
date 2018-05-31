package ru.nikitadrzh.omdbclient.ui.movie.list;


import android.util.Log;

import java.util.List;

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
    //todo после создания с master соединить

    //в RxJava2 вместо subscription - disposable
    private Disposable disposable;

    //todo заинджектить, но пока что просто создать, и передать в него заглушку - репозиторий,
    //todo который реализовавается в data(или временно в app)
    private FindMoviesUseCase findMoviesUseCase;

    //todo заинджектить
    private MovieViewModelMapper movieViewModelMapper;

    //todo заинжектить
    private MovieRepository repository;

    /*
    По-сути сюда именно MainActivity приходит, но cast под MoviesContract.View, так что впринципе
    это нормально, к примеру, мы можем легко заменить MainActivity на фрагмент, реализующий .View,
    при этом код презентера вообще не поменяется никак! Так как этого и добиваемся, то тест пройден
    */
    private MoviesContract.View view;

    public MoviesPresenter(MoviesContract.View view, MovieRepository repository,
                           MovieViewModelMapper mapper) {//todo repo и mapper тут, потмоу что пока без DI
        this.view = view;
        this.repository = repository;
        this.movieViewModelMapper = mapper;
        findMoviesUseCase = new FindMoviesUseCase(repository);//todo зачем тут репо?
        Log.i("TEST!", "MoviesContract.View has name: " + view.getClass().getName());
    }

    @Override
    public void findMovies(String movieTitle) {
        disposable = findMoviesUseCase.execute(movieTitle)
                .map(movieViewModelMapper::mapMovieToViewModel)//конвертируем во вьюмодель
                .subscribe(this::showFoundMovies, Throwable::printStackTrace);
    }

    private void showFoundMovies(List<MovieViewModel> foundMovies) {
        //todo хотя бы до сюда должно все проходить после создания маппера, если не проходит, значит
        //todo все таки надо repoImpl передавать а не repo, а также при создании mappera тоже надо
        //todo передавать конкретный экземпляр, а мы какбы передаем интерфейс
        view.showMovies(foundMovies);
    }
}
