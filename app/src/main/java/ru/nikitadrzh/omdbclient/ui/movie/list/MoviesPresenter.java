package ru.nikitadrzh.omdbclient.ui.movie.list;


import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import ru.nikitadrzh.domain.interactor.movie.FindMoviesUseCase;
import ru.nikitadrzh.omdbclient.ui.mapper.MovieViewModelMapper;
import ru.nikitadrzh.omdbclient.ui.model.MovieViewModel;

/*
Данный класс - реализация презентера, который по запросу view предоставляет список фильмов, класс
реализовывает контракт, в котором прописаны функции объекта
 */
public class MoviesPresenter implements MoviesContract.Presenter {

    //в RxJava2 вместо subscription - disposable
    private Disposable disposable;

    //todo заинджектить
    private FindMoviesUseCase findMoviesUseCase;

    //todo заинджектить
    private MovieViewModelMapper movieViewModelMapper;

    /*
    методы по этой ссылки вызваются через класс, который реализует .View (Это не нарушает того
    принципа, что внутренний слой ничего не должен знать о внешнем, так как реализовать этот
    интерфейс может кто угодно, todo поэтому и используется BasePresenter, так как такие поля и
    todo логика будут у всех презентеров)
    Тут по сути, если .View станет реализовывать кто-то другой, то презентер от этого никак не
    поменяется
     */
    private MoviesContract.View view;

    public MoviesPresenter(MoviesContract.View view) {
        this.view = view;
    }

    @Override
    public void findMovies(String movieTitle) {
        disposable = findMoviesUseCase.execute(movieTitle)
                .map(movieViewModelMapper::mapMovieToViewModel)//конвертируем во вьюмодель
                .subscribe(this::showFoundMovies, Throwable::printStackTrace);
    }

    private void showFoundMovies(List<MovieViewModel> foundMovies) {

        //логика отображения именно из презентера осуществляется, а не из фрагмента
        view.showMovies(foundMovies);
    }
}
