package ru.ybrynkin.dmdev.hw.task3.oop;

import ru.ybrynkin.dmdev.hw.task3.oop.building.Building;

public class BuildingRunner {

  public static void main(String[] args) {
    Building building1 = new Building(1, 10, 4);
    building1.print();

    Building building2 = new Building(2, 3, 5);
    Building.printAllInformation(building2);
  }

}
