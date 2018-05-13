package ru.nikitadrzh.omdbclient.ui;

import ru.nikitadrzh.omdbclient.MainActivity;

public final class MainPresenter {

    //todo зачем этот конструктор, кто его вызывает?
    public MainPresenter(final MainActivity view) {

        //todo что такое Subscription?
        //todo оператор map?
        //todo subscribeOn - показывает в каком потоке надо выполнять () (один на цепь)
        //todo observeOn - показывает в какой поток вернуться и продолжить цепочку (можно хоть
        //todo несколько делать, тк. выполняется все что ниже по цепи)
    }
}
