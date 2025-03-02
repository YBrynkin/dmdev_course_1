package ru.ybrynkin.dmdev.hw.task4.inheritance.space.utils;

import ru.ybrynkin.dmdev.hw.task4.inheritance.space.SpaceObject;
import ru.ybrynkin.dmdev.hw.task4.inheritance.space.Star;

public final class SpaceUtils {

  //Gravitational constant
  public static final double GRAVITATIONAL_CONSTANT = 6.67430e-11;

  //Private constructor to prevent instantiation
  private SpaceUtils() {
  }

  /**
   * Calculates the gravitational force between two space objects.
   * @param obj1     The first space object.
   * @param obj2     The second space object.
   * @param distance The distance between the two objects in meters.
   * @return The gravitational force in newtons.
   */
  public static double calculateGravitationalForce(SpaceObject obj1, SpaceObject obj2,
      double distance) {
    if (distance <= 0) {
      throw new IllegalArgumentException("Distance must be greater than zero.");
    }
    return (GRAVITATIONAL_CONSTANT * obj1.getMass() * obj2.getMass()) / (distance * distance);
  }

  /**
   * Determines if a space object is a star.
   * @param obj The space object to check.
   * @return True if the object is a star, false otherwise.
   */
  public static boolean isStar(SpaceObject obj) {
    return obj instanceof Star;
  }
}
