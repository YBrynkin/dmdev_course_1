package ru.ybrynkin.dmdev.hw.task7.csv.model;

import java.util.Objects;

/**
 * Special class which represents "merged" item
 */
public class MergedItem {

  private final int id;
  private final String name;
  private final String price;

  public MergedItem(int id, String name, String price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    MergedItem that = (MergedItem) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(
        price, that.price);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + Objects.hashCode(name);
    result = 31 * result + Objects.hashCode(price);
    return result;
  }
}
