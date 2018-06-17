package ru.nikitadrzh.domain.model;

//movie model
public final class Movie {
    private final String title;
    private final String type;
    private final String year;
    private final String posterUrl;
    private final boolean isFavourite;

    public Movie(String title, String type, String year, String posterUrl, boolean isFavourite) {
        this.title = title;
        this.type = type;
        this.year = year;
        this.posterUrl = posterUrl;
        this.isFavourite = isFavourite;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title=" + title +
                ", type=" + type +
                ", year" + year +
                ", posterUrl" + posterUrl +
                ", isFavourite" + isFavourite +
                "}";
    }

    public String getTitle() {
        return title;
    }
}
