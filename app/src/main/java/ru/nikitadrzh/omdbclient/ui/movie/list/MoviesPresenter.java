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
    todo по-сути в конструктор презентера передается класс, который cast к View, то есть в него
    todo вроде как не приходит ссылка типа, который реализует View, тогда все нормально, но надо
    todo это протестировать, чтобы убедиться, что точно MoviesContract.View приходит в коснтруктор
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
/*
    todo если тест удачен, то тут просто для всех кто реализует View вызывается метод, то есть
    todo логика отображения именно из презентера осуществляется, а не из фрагмента!!!
    По-сути в этом и есть предназначение этого класса
 */
        view.showMovies(foundMovies);
    }
}
