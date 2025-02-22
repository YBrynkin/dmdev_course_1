package ru.ybrynkin.dmdev.hw.task3.oop;

import java.util.Random;

public class Floor {

  //Floor's number
  private int number;
  //Maximum rooms count
  private static final int MAX_ROOM_COUNT = 5;
  //Minimum rooms count
  private static final int MIN_ROOM_COUNT = 1;

  public Flat[] getFlats() {
    return flats;
  }

  //Arrays of flats
  private Flat[] flats;

  public Floor(int number, int flatsCount) {
    this.number = number;
    flats = createFlats(flatsCount);

  }

  //Create an array of flats for a floor
  private Flat[] createFlats(int flatsCount) {
    Flat[] tmpFlats = new Flat[flatsCount];
    for (int i = 1; i <= flatsCount; i++) {
      int flatNumber = (this.number - 1) * flatsCount + i;
      int roomCount = getRandomIntInRange(MIN_ROOM_COUNT, MAX_ROOM_COUNT);
      tmpFlats[i - 1] = new Flat(flatNumber, roomCount);
    }
    return tmpFlats;
  }

  public void print() {
    System.out.printf("Floor with number %d contains %d apartments\n", number, flats.length);
    for (Flat flat : flats) {
      System.out.print("  ");
      flat.print();
    }
  }

  // Method to generate a random integer within a specified range [min, max]
  private static int getRandomIntInRange(int min, int max) {
    if (min > max) {
      throw new IllegalArgumentException("Min must be less than or equal to max");
    }

    Random random = new Random();
    return random.nextInt((max - min) + 1) + min;
  }
}
