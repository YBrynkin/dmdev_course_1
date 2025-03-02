package ru.ybrynkin.dmdev.hw.task4.inheritance.space;

//Class which explains starts
public class Star extends SpaceObject implements Luminous {

  private double temperature; //In Kelvin

  public Star(String name, double mass, double radius, double temperature) {
    super(name, mass, radius);
    this.temperature = temperature;
  }

  @Override
  public boolean isHabitable(double temperature) {
    return false; //Stars are not habitable
  }

  //Implement Luminous interface
  @Override
  public void emitLight() {
    System.out.println(getName() + " is emitting light.");
  }

  //Custom method: Calculate luminosity
  public double calculateLuminosity() {
    return temperature * getRadius() * getRadius(); // Simplified formula
  }


  @Override
  public String toString() {
    return "Star [Name: " + getName() + ", Mass: " + getMass() + " kg, Radius: " + getRadius()
        + " km, Temperature: " + temperature + " K]";
  }
}
