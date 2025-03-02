package ru.ybrynkin.dmdev.hw.task4.inheritance.space;

public class Galaxy {

  private String name;
  private SpaceObject[] spaceObjects;

  public Galaxy(String name, SpaceObject[] spaceObjects) {
    this.name = name;
    this.spaceObjects = spaceObjects;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Galaxy: ").append(name).append("\n");
    sb.append("Contains the following space objects:\n");
    for (SpaceObject obj : spaceObjects) {
      sb.append(obj.toString()).append("\n");
    }
    return sb.toString();
  }
}

