package ru.ybrynkin.dmdev.hw.task3.oop;

public class Room {

  private final boolean isCommunicatingRoom;

  public Room(boolean isCommunicatingRoom) {
    this.isCommunicatingRoom = isCommunicatingRoom;
  }

  public void print() {
    if (isCommunicatingRoom) {
      System.out.println("The room is a walk-through");
    } else {
      System.out.println("The room is not a walk-through");
    }
  }

}
