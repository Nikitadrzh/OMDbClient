package ru.nikitadrzh.omdbclient;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.nikitadrzh.omdbclient.base.BaseActivity;

//todo зачем наследовать от baseActivity?
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //todo как применяется?
//    @Override
//    protected void inject(final ActivityComponent activityComponent) {
//        activityComponent.inject(this);
//    }
}
