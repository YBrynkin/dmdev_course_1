package ru.ybrynkin.dmdev.hw.task1;

/**
 * Задание 1
 *
 * В переменной minutes лежит число от 0 до 59. Написать функцию, которая принимает в качестве
 * параметра значение переменной minutes и выводит на консоль в какую четверть часа попадает это
 * число (в первую, вторую, третью или четвертую).
 *
 * Протестировать функцию в main.
 */

public class Task1 {

  private static void printQuarterOfHour(int minutes) {
    if (minutes > 0) {
      int quarter = minutes / 15 + 1;
      switch (quarter) {
        case 1 -> System.out.println("1st quarter");
        case 2 -> System.out.println("2nd quarter");
        case 3 -> System.out.println("3d quarter");
        case 4 -> System.out.println("4th quarter");
        default -> System.out.println("Wrong input: the value exceeds 60!");
      }
    } else {
      System.out.println("Wrong input: the value is below zero!");
    }
  }

  public static void main(String[] args) {
    //Test hour function
    printQuarterOfHour(2); // 1st
    printQuarterOfHour(17); // 2d
    printQuarterOfHour(43); // 3d
    printQuarterOfHour(59); // 4th
    printQuarterOfHour(61); //Wrong
    printQuarterOfHour(-10); //Wrong
  }

}
