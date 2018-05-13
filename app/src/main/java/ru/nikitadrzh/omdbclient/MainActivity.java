package ru.nikitadrzh.omdbclient;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import ru.nikitadrzh.omdbclient.ui.model.MovieViewModel;
import ru.nikitadrzh.omdbclient.ui.movie.list.MoviesContract;
import ru.nikitadrzh.omdbclient.ui.movie.list.MoviesPresenter;


//для теста сделаем активити без DI и проч. просто чтобы вызвать фрагмент и его протестить
public class MainActivity extends AppCompatActivity implements MoviesContract.View {

    private MoviesPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new MoviesPresenter(MainActivity.this);
        callPresenter();
    }

    public void callPresenter() {
        presenter.findMovies("kekTV");
    }

    @Override
    public void showMovies(List<MovieViewModel> moviesToShow) {

    }
}
