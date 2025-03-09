package ru.ybrynkin.dmdev.hw.task5.collections2.task1.cinema;

public class Film {

  private final int id;
  private final String title;
  private final int releaseYear;
  private final int releaseMonth;
  private final FilmGenre genre;
  private final int rating;

  public Film(int id, String title, int releaseYear, int releaseMonth, FilmGenre genre,
      int rating) {
    this.id = id;
    this.title = title;
    this.releaseYear = releaseYear;
    this.releaseMonth = releaseMonth;
    this.genre = genre;
    this.rating = rating;
  }

  public int getId() {
    return id;
  }

  public FilmGenre getGenre() {
    return genre;
  }

  public String getTitle() {
    return title;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public int getReleaseMonth() {
    return releaseMonth;
  }

  public int getRating() {
    return rating;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Film{");
    sb.append("id=").append(id);
    sb.append(", title='").append(title).append('\'');
    sb.append(", releaseYear=").append(releaseYear);
    sb.append(", releaseMonth=").append(releaseMonth);
    sb.append(", genre=").append(genre);
    sb.append(", rating=").append(rating);
    sb.append('}');
    return sb.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Film film = (Film) o;
    return id == film.id && releaseYear == film.releaseYear
        && releaseMonth == film.releaseMonth && rating == film.rating && title.equals(
        film.title) && genre == film.genre;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + title.hashCode();
    result = 31 * result + releaseYear;
    result = 31 * result + releaseMonth;
    result = 31 * result + genre.hashCode();
    result = 31 * result + rating;
    return result;
  }


}
