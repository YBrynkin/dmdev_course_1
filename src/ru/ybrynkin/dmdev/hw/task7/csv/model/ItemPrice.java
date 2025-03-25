package ru.ybrynkin.dmdev.hw.task7.csv.model;

/**
 * Special class for item's price
 */

public class ItemPrice {

  private final int id;
  private final String price;

  public ItemPrice(int id, String price) {
    this.id = id;
    this.price = price;
  }

  // Getters
  public int getId() {
    return id;
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

    ItemPrice itemPrice = (ItemPrice) o;
    return id == itemPrice.id && price.equals(itemPrice.price);
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + price.hashCode();
    return result;
  }
}
