package ru.nikitadrzh.omdbclient;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import javax.inject.Inject;

import ru.nikitadrzh.omdbclient.ui.dagger.ActivityComponent;
import ru.nikitadrzh.omdbclient.ui.dagger.DaggerActivityComponent;
import ru.nikitadrzh.omdbclient.ui.dagger.module.MoviesFragmentModule;
import ru.nikitadrzh.omdbclient.ui.dagger.module.PagerAdapterModule;


public class MainActivity extends AppCompatActivity {

    @Inject
    public FragmentStatePagerAdapter adapter;

    public static ActivityComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omdb);

        component = DaggerActivityComponent.builder()
                .pagerAdapterModule(new PagerAdapterModule(this))
                .moviesFragmentModule(new MoviesFragmentModule())
                .build();

        component.injectTo(this);

        //todo findview нельзя объявлять в полях...почему? и как быть с DI?
        ViewPager pager = findViewById(R.id.view_pager);

        pager.setAdapter(adapter);
    }
}
