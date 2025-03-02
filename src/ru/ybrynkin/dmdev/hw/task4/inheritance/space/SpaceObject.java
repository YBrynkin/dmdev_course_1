package ru.ybrynkin.dmdev.hw.task4.inheritance.space;


public abstract class SpaceObject {

  private String name; // name of our space object
  private double mass; // in kilograms
  private double radius; // in kilometers

  protected static final double MIN_HABITABLE_TEMPERATURE = 200; // Minimum habitable temperature in Kelvin
  protected static final double MAX_HABITABLE_TEMPERATURE = 400; // Maximum habitable temperature in Kelvin

  public SpaceObject(String name, double mass, double radius) {
    this.name = name;
    this.mass = mass;
    this.radius = radius;
  }

  public String getName() {
    return name;
  }

  public double getMass() {
    return mass;
  }

  public double getRadius() {
    return radius;
  }

  //Abstract method to determine if the object is habitable
  public abstract boolean isHabitable(double temperature);

  //Method to calculate diameter
  public double calculateDiameter() {
    return 2 * radius;
  }

  //Method to compare masses
  public int compareMass(SpaceObject other) {
    return Double.compare(this.mass, other.mass);
  }
}


