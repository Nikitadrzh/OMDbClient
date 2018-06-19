package ru.nikitadrzh.omdbclient.ui.dagger.module;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import dagger.Module;
import dagger.Provides;
import ru.nikitadrzh.omdbclient.MainActivity;
import ru.nikitadrzh.omdbclient.ui.movie.content.MovieFragment;
import ru.nikitadrzh.omdbclient.ui.movie.list.MoviesFragment;

@Module
public class PagerAdapterModule {

    private MainActivity activity;

    public PagerAdapterModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    public FragmentStatePagerAdapter getAdapter() {
        return new FragmentStatePagerAdapter(activity.getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new MoviesFragment();
                    case 1:
                        return new MovieFragment();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "Search";
                    case 1:
                        return "Favourites";
                    default:
                        return null;
                }
            }
        };
    }
}
