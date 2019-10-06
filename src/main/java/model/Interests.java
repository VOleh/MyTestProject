package model;

public class Interests {
    private String films;
    private String books;
    private String music;
    private String sport;

    public Interests(String films, String books, String music, String sport) {
        this.films = films;
        this.books = books;
        this.music = music;
        this.sport = sport;
    }

    public Interests() {
    }

    public String getFilms() {
        return films;
    }

    public void setFilms(String films) {
        this.films = films;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
