package ru.ybrynkin.dmdev.hw.task4.inheritance.space;

public class Comet extends SpaceObject implements Orbitable {

  private double tailLength; // in kilometers

  private static final double BRIGHTNESS_COMET_COEFFICIENT = 0.6; // Special brightness coefficient

  public Comet(String name, double mass, double radius, double tailLength) {
    super(name, mass, radius);
    this.tailLength = tailLength;
  }

  @Override
  public void orbit() {
    System.out.println(getName() + " is orbiting the Sun with a tail.");
  }

  @Override
  public boolean isHabitable(double temperature) {
    return false; // Comets are not habitable
  }

  //Custom method: Calculate tail brightness
  public double calculateTailBrightness() {
    return BRIGHTNESS_COMET_COEFFICIENT * tailLength * getMass(); // Simplified formula
  }

  @Override
  public String toString() {
    return "Comet [Name: " + getName() + ", Mass: " + getMass() + " kg, Radius: " + getRadius()
        + " km, Tail Length: " + tailLength + " km]";
  }
}
