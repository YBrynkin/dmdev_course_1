package ru.ybrynkin.dmdev.hw.task4.inheritance.space;

public class Moon extends Planet {

  private String orbitsPlanet;

  public Moon(String name, double mass, double radius, String orbitsPlanet) {
    super(name, mass, radius, 0); // Moons have no moons of their own
    this.orbitsPlanet = orbitsPlanet;
  }

  @Override
  public void orbit() {
    System.out.println(getName() + " is orbiting " + orbitsPlanet + ".");
  }

  @Override
  public String toString() {
    return "Moon [Name: " + getName() + ", Mass: " + getMass() + " kg, Radius: " + getRadius()
        + " km, Orbits Planet: " + orbitsPlanet + "]";
  }
}
