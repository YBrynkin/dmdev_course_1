package ru.ybrynkin.dmdev.hw.task3.oop;

import java.util.Random;

public class Flat {

  //Number of a flat
  private int number;
  //Rooms of a flat
  private Room[] rooms;

  public Room[] getRooms() {
    return rooms;
  }

  public Flat(int number, int roomsCount) {
    this.number = number;
    rooms = createRooms(roomsCount);
  }

  //Create rooms for a flat
  private Room[] createRooms(int roomsCount) {
    Room[] tmpRooms = new Room[roomsCount];
    boolean isCommunicatingRoom = true;
    for (int i = 0; i < roomsCount; i++) {
      if (new Random().nextInt(10) % 2 == 0) {
        isCommunicatingRoom = false;
      }
      tmpRooms[i] = new Room(isCommunicatingRoom);
    }
    return tmpRooms;
  }

  public void print() {
    System.out.printf("The flat with number %d contains %d rooms\n", number, rooms.length);
    for (Room room : rooms) {
      System.out.print(" ");
      room.print();
    }
  }

}
