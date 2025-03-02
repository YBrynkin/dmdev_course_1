package ru.ybrynkin.dmdev.hw.task4.inheritance.space;

public class Asteroid extends SpaceObject implements Orbitable {

  private String composition; // Composition of our asteroid

  public Asteroid(String name, double mass, double radius, String composition) {
    super(name, mass, radius);
    this.composition = composition;
  }

  @Override
  public boolean isHabitable(double temperature) {
    return false; // Asteroids are not habitable
  }

  @Override
  public void orbit() {
    System.out.println(getName() + " is orbiting the Sun.");
  }

  @Override
  public String toString() {
    return "Asteroid [Name: " + getName() + ", Mass: " + getMass() + " kg, Radius: " + getRadius()
        + " km, Composition: " + composition + "]";
  }
}
