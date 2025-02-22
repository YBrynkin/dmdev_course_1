package ru.ybrynkin.dmdev.hw.task3.oop;

/**
 * This class is a template for an apartment building with one entrance. To create a building, enter
 * its floor number and the number of apartments per floor. The number of rooms is determined in the
 * class Flat
 */
public class Building {

  //Building's number
  private int number;
  //Array of floors
  private Floor[] floors;

  public Building(int number, int floorsCount, int flatsCount) {
    this.number = number;
    floors = createFloors(floorsCount, flatsCount);
  }

  private Floor[] createFloors(int floorsCount, int flatsCount) {
    Floor[] tmpFloors = new Floor[floorsCount];
    for (int i = 1; i <= floorsCount; i++) {
      int floorNumber = i;
      tmpFloors[i - 1] = new Floor(floorNumber, flatsCount);
    }
    return tmpFloors;
  }

  public void print() {
    System.out.printf("Building number is %d, number of floors is %d\n", number, floors.length);
  }

  public static void printAllInformation(Building building) {
    System.out.printf("Building with number %d contains %d floors\n", building.number,
        building.floors.length);
    for (int i = 0; i < building.floors.length; i++) {
      System.out.print(" ");
      building.floors[i].print();
    }
  }

}
