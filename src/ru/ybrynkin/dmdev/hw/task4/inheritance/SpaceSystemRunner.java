package ru.ybrynkin.dmdev.hw.task4.inheritance;

import ru.ybrynkin.dmdev.hw.task4.inheritance.space.*;
import ru.ybrynkin.dmdev.hw.task4.inheritance.space.utils.SpaceUtils;

//Main class to demonstrate the work of space system
public class SpaceSystemRunner {

  public static void main(String[] args) {
    Star sun = new Star("Sun", 1.989e30, 696340, 5778);
    Planet earth = new Planet("Earth", 5.972e24, 6371, 1);
    Moon moon = new Moon("Moon", 7.342e22, 1737, "Earth");
    Asteroid ceres = new Asteroid("Ceres", 9.393e20, 473, "Rocky");
    Comet halley = new Comet("Halley's Comet", 2.2e14, 5.5, 24);

    //Create a galaxy and add space objects
    SpaceObject[] solarSystem = {sun, earth, moon, ceres, halley};
    Galaxy milkyWay = new Galaxy("Milky Way", solarSystem);

    System.out.println(milkyWay);

    // Calculate gravitational force (in newtons!) between the Sun and Earth
    double distanceSunToEarth = 149.6e9; // Distance in meters (1 AU)
    double gravitationalForce = SpaceUtils.calculateGravitationalForce(sun, earth, distanceSunToEarth);
    System.out.println("Gravitational force between Sun and Earth: " + gravitationalForce + " N");

    // Check if an object is a star
    System.out.println("Is Sun a star? " + SpaceUtils.isStar(sun)); // true
    System.out.println("Is Earth a star? " + SpaceUtils.isStar(earth)); // false

    //Demonstrate polymorphism and interfaces
    for (SpaceObject obj : solarSystem) {
      if (obj instanceof Luminous) {
        ((Luminous) obj).emitLight();
      }
      if (obj instanceof Orbitable) {
        ((Orbitable) obj).orbit();
      }
      if (obj instanceof Explorable) {
        ((Explorable) obj).explore();
      }
      System.out.println();
      // Demonstrate custom methods
      System.out.println("Luminosity of Sun: " + sun.calculateLuminosity());
      System.out.println("Gravity of Earth: " + earth.calculateGravity());

      System.out.println();
    }
  }

}
