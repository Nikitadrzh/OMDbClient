package ru.nikitadrzh.omdbclient.ui.movie.list;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import ru.nikitadrzh.omdbclient.MainActivity;
import ru.nikitadrzh.omdbclient.R;
import ru.nikitadrzh.omdbclient.ui.dagger.ActivityComponent;
import ru.nikitadrzh.omdbclient.ui.dagger.DaggerFragmentComponent;
import ru.nikitadrzh.omdbclient.ui.dagger.FragmentComponent;
import ru.nikitadrzh.omdbclient.ui.dagger.module.FindMoviesUseCaseModule;
import ru.nikitadrzh.omdbclient.ui.dagger.module.MovieViewModelMapperModule;
import ru.nikitadrzh.omdbclient.ui.dagger.module.MoviesFragmentModule;
import ru.nikitadrzh.omdbclient.ui.dagger.module.MoviesPresenterModule;
import ru.nikitadrzh.omdbclient.ui.model.MovieViewModel;

public class MoviesFragment extends Fragment implements MoviesContract.View {

    @Inject
    public MoviesPresenter presenter;

    //todo все что связано с findView, как с ним быть с точки зрения DI???
    private TextInputEditText inputEditText;
    private Button foundButton;

    public static FragmentComponent fragmentComponent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentComponent = DaggerFragmentComponent.builder()
                .moviesPresenterModule(new MoviesPresenterModule(this))
                .activityComponent(MainActivity.component)
                .build();

        fragmentComponent.injectTo(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //todo както через binder сделать?
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        inputEditText = view.findViewById(R.id.input_edit_text);
        foundButton = view.findViewById(R.id.found_button);
        foundButton.setOnClickListener(v -> {
            try {
                showFoundMovies(inputEditText.getText().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return view;
    }

    @Override
    public void showMovies(List<MovieViewModel> moviesToShow) {
        //todo и здесь уже идет отображение в recyclerView
        Toast.makeText(getActivity(), moviesToShow.get(0).toString(), Toast.LENGTH_LONG).show();
    }

    //это внутренний  метод, вызываемый из самого фрагмента
    private void showFoundMovies(String request) throws IOException {
        presenter.findMovies(request);
    }
}
