package ru.ybrynkin.dmdev.hw.task4.inheritance.space;

public class Planet extends SpaceObject implements Orbitable, Explorable {

  private int numberOfMoons;

  public Planet(String name, double mass, double radius, int numberOfMoons) {
    super(name, mass, radius);
    this.numberOfMoons = numberOfMoons;
  }

  @Override
  public boolean isHabitable(double temperature) {
    return temperature >= MIN_HABITABLE_TEMPERATURE
        && temperature <= MAX_HABITABLE_TEMPERATURE; // Habitable temperature range in Kelvin
  }

  @Override
  public void orbit() {
    System.out.println(getName() + " is orbiting a star.");
  }

  @Override
  public void explore() {
    System.out.println(getName() + " is being explored.");
  }

  // Custom method: Calculate gravity
  public double calculateGravity() {
    return getMass() / (getRadius() * getRadius()); // Simplified formula
  }

  @Override
  public String toString() {
    return "Planet [Name: " + getName() + ", Mass: " + getMass() + " kg, Radius: " + getRadius()
        + " km, Number of Moons: " + numberOfMoons + "]";
  }
}


