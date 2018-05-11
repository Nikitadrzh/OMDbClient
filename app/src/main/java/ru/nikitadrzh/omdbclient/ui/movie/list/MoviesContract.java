package ru.nikitadrzh.omdbclient.ui.movie.list;

/*
В этом интерфейсе описывается, что должна делать View (которая отвечает за список фильмов) и что
должен делать Presenter
 */
public interface MoviesContract {

    //todo тут опущено наследование от BaseView (пока)
    //описание функций View
    interface View {

        //todo методу нужен аргуемент, но пока типа нет такого
        void showMovies();
    }

    //todo тут опущено наследование от ScopedPresenter (пока)
    //описание функций презентера
    interface Presenter {
        void findMovies(String movieTitle);
    }
}
