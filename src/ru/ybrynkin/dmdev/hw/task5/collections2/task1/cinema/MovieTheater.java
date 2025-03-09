package ru.ybrynkin.dmdev.hw.task5.collections2.task1.cinema;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class MovieTheater {

  // Array of sorted films
  private TreeMap<Integer, LinkedHashSet<Film>> films;

  // Private constructor with parameters
  private MovieTheater(TreeMap<Integer, LinkedHashSet<Film>> films) {
    this.films = films;
  }

  public MovieTheater() {
    this.films = new TreeMap<>();
  }

  public void add(Film film) {
    if (film != null) {
      // Create temporary set of theater's films
      LinkedHashSet<Film> tempSet = this.films.get(film.getReleaseYear());
      if (tempSet != null) {
        tempSet.add(film);
      } else {
        tempSet = new LinkedHashSet<>();
        tempSet.add(film);
        this.films.put(film.getReleaseYear(), tempSet);
      }
    } else {
      throw new IllegalArgumentException("Film cannot be null");
    }
  }

  // Get set of films by the release year
  public Set<Film> getFilmsByReleaseYear(int releaseYear) {
    // If not found return new linked set
    return films.getOrDefault(releaseYear, new LinkedHashSet<>());
  }

  // Get set of films by the release year and month
  public Set<Film> getFilmsByReleaseYearAndMonth(int releaseYear,
      int releaseMonth) {
    // Filter films by a release year
    Set<Film> filteredSet = getFilmsByReleaseYear(releaseYear);
    // Iterate over filtered set to remove unmatched films by a release month
    Iterator<Film> tempFilms = filteredSet.iterator();
    while (tempFilms.hasNext()) {
      Film film = tempFilms.next();
      if (film.getReleaseMonth() != releaseMonth) {
        tempFilms.remove();
      }
    }
    return filteredSet;
  }

  // Get set of films by film's genre
  public Set<Film> getFilmsByGenre(FilmGenre genre) {
    // Create container for filtered films
    Set<Film> filteredSet = new LinkedHashSet<>();
    // Iterate over treemap to remove unmatched films by film's genre
    for (Entry<Integer, LinkedHashSet<Film>> entry : this.films.entrySet()) {
      for (Film film : entry.getValue()) {
        if (Objects.equals(film.getGenre(), genre)) {
          filteredSet.add(film);
        }
      }
    }
    return filteredSet;
  }

  // Get the top 10 movies sorted by rating in descending order
  public List<Film> getTopTenFilms() {
    List<Film> allFilms = new ArrayList<>();
    for (LinkedHashSet<Film> films : films.values()) {
      allFilms.addAll(films);
    }
    // Sort by rating in descending order
    allFilms.sort(new Comparator<Film>() {
      @Override
      public int compare(Film film1, Film film2) {
        return Integer.compare(film2.getRating(), film1.getRating());
      }
    });
    // Return the top 10 films
    return allFilms.subList(0, Math.min(10, allFilms.size()));

  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("MovieTheater{");
    sb.append("films=").append(films);
    sb.append('}');
    return sb.toString();
  }
}
