package ru.ybrynkin.dmdev.hw.task5.collections2.task1;

import ru.ybrynkin.dmdev.hw.task5.collections2.task1.cinema.Film;
import ru.ybrynkin.dmdev.hw.task5.collections2.task1.cinema.FilmGenre;
import ru.ybrynkin.dmdev.hw.task5.collections2.task1.cinema.MovieTheater;

public class CinemaRunner {

  public static void main(String[] args) {

    MovieTheater theater = new MovieTheater();

    // Add films to the cinema
    theater.add(new Film(1, "Snatch", 2000, 5, FilmGenre.ACTION, 10));
    theater.add(new Film(3, "Inception", 2010, 6, FilmGenre.ACTION, 9));
    theater.add(new Film(4, "Ad Astra", 2019, 4, FilmGenre.SCI_FI, 3));
    theater.add(new Film(5, "Bruce Almighty", 2003, 5, FilmGenre.COMEDY, 7));
    theater.add(new Film(6, "Toy Story", 1995, 4, FilmGenre.ANIMATION, 5));
    theater.add(new Film(7, "The Matrix", 1999, 5, FilmGenre.SCI_FI, 9));
    theater.add(new Film(8, "Gladiator", 2000, 7, FilmGenre.ACTION, 8));
    theater.add(new Film(9, "The Godfather", 1972, 9, FilmGenre.CRIME, 2));
    theater.add(new Film(11, "Fight Club", 1999, 8, FilmGenre.DRAMA, 5));
    theater.add(new Film(12, "The Lord of the Rings: The Fellowship of the Ring", 2001, 8,
        FilmGenre.FANTASY, 10));
    theater.add(new Film(13, "Titanic", 1997, 7, FilmGenre.ROMANCE, 2));
    theater.add(new Film(6, "Forrest Gump", 1994, 7, FilmGenre.DRAMA, 3));

    //Try adding duplicate
    theater.add(new Film(1, "Snatch", 2000, 5, FilmGenre.ACTION, 10)); // Duplication

    // Get films by year
    System.out.println("Films released in 1994:");
    for (Film film : theater.getFilmsByReleaseYear(1994)) {
      System.out.println(film);
    }

    // Get films by year and month
    System.out.println("\nFilms released in July 1994:");
    for (Film film : theater.getFilmsByReleaseYearAndMonth(1994, 7)) {
      System.out.println(film);
    }

    // Get films by genre
    System.out.println("\nAll Sci-Fi films:");
    for (Film film : theater.getFilmsByGenre(FilmGenre.SCI_FI)) {
      System.out.println(film);
    }

    // Get top 10 movies by rating
    System.out.println("\nTop 10 movies by rating:");
    for (Film film : theater.getTopTenFilms()) {
      System.out.println(film);
    }

  }

}
