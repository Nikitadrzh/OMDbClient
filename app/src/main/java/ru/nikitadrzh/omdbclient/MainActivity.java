package ru.nikitadrzh.omdbclient;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


import ru.nikitadrzh.omdbclient.ui.MovieRepositoryImpl;
import ru.nikitadrzh.omdbclient.ui.mapper.MovieViewModelMapperImpl;
import ru.nikitadrzh.omdbclient.ui.model.MovieViewModel;
import ru.nikitadrzh.omdbclient.ui.movie.list.MoviesContract;
import ru.nikitadrzh.omdbclient.ui.movie.list.MoviesPresenter;


//для теста сделаем активити без DI и проч.
public class MainActivity extends AppCompatActivity implements MoviesContract.View {

    //todo надо инжектить
    private MoviesPresenter presenter;

    private EditText requestView;
    private TextView responseView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omdb);

        //todo в конструкторе презентера столько всего просто, потому что пока без DI
        presenter = new MoviesPresenter(this, new MovieRepositoryImpl(),
                new MovieViewModelMapperImpl());

        requestView = findViewById(R.id.requestView);
        Button foundButton = findViewById(R.id.findButton);
        responseView = findViewById(R.id.responseView);

        //todo через RX сделать
        foundButton.setOnClickListener(v -> showFoundMovies(requestView.getText().toString()));
    }

    private void showFoundMovies(String request) {
        presenter.findMovies(request);
    }

    @Override
    public void showMovies(List<MovieViewModel> moviesToShow) {
        //todo в этом методе надо отобразить, например просто в текст вью, список фильмов, те. надо
        //todo тект вью создать
    }
}
