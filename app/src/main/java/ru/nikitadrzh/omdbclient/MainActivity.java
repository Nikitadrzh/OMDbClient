package ru.nikitadrzh.omdbclient;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import javax.inject.Inject;

import ru.nikitadrzh.omdbclient.ui.movie.content.MovieFragment;
import ru.nikitadrzh.omdbclient.ui.movie.list.MoviesFragment;


//для теста сделаем активити без DI и проч.
public class MainActivity extends AppCompatActivity {

    @Inject
    public FragmentStatePagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omdb);

        //todo findview нельзя объявлять в полях...почему? и как быть с DI?
        ViewPager pager = findViewById(R.id.view_pager);

        pager.setAdapter(adapter);
    }
}
