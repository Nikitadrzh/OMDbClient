package ru.nikitadrzh.omdbclient.ui.movie.list;

/*
В этом интерфейсе описывается, что должна делать View (которая отвечает за список фильмов) и что
должен делать Presenter
 */
public interface MoviesContract {

    //todo тут опущено наследование от BaseView (пока)
    /*
    Данный интерфейс View реализуется непосредственно уже в активити/фрагменте, очень удобно, можно
     описывать логику вызовов этих методов View из презентера, не имея еще даже самих представлений
     */
    interface View {

        //todo методу нужен аргуемент, но пока типа нет такого
        void showMovies();
    }

    //todo тут опущено наследование от ScopedPresenter (пока)
    //описание функций презентера
    interface Presenter {

        //метод поиска фильмов по названию
        void findMovies(String movieTitle);
    }
}
