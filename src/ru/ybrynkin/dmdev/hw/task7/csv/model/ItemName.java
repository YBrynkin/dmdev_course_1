package ru.ybrynkin.dmdev.hw.task7.csv.model;

import java.util.Objects;

/**
 * Special class for item's name and description
 */

public class ItemName {

  private final int id;
  private final String name;
  private final String description;

  public ItemName(int id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  // Getters
  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ItemName itemName = (ItemName) o;
    return id == itemName.id && Objects.equals(name, itemName.name)
        && Objects.equals(description, itemName.description);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + Objects.hashCode(name);
    result = 31 * result + Objects.hashCode(description);
    return result;
  }
}
