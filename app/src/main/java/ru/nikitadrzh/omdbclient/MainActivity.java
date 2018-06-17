package ru.nikitadrzh.omdbclient;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import ru.nikitadrzh.omdbclient.ui.movie.content.MovieFragment;
import ru.nikitadrzh.omdbclient.ui.movie.list.MoviesFragment;


//для теста сделаем активити без DI и проч.
public class MainActivity extends AppCompatActivity {

    //todo надо инжектить
    private FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_omdb);

        //todo findview нельзя объявлять в полях...почему? и как быть с DI?
        ViewPager pager = findViewById(R.id.view_pager);

        pager.setAdapter(adapter);
    }
}
