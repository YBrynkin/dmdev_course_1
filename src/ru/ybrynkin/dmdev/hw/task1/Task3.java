package ru.ybrynkin.dmdev.hw.task1;

  /**
   * Задание 3
   *
   * Даны два прямоугольных треугольника. Каждый из них задается двумя целочисленными переменными a и
   * b - стороны треугольника. Написать код, в котором вычисляется площадь каждого треугольника и
   * затем эти площади сравниваются друг с другом.
   *
   * Для этого понадобится написать 2 функции. Первая: по двум сторонам прямоугольного треугольника
   * возвращает его площадь. Вторая: сравнивает переданные площади двух треугольников и выводит на
   * консоль первый треугольник больше, меньше или равен второму. Учитывать, что площадь может быть
   * вещественным числом.
   */

  public class Task3 {

    private static double getTriangleArea(int a, int b) {
      return (double) (a * b) / 2;
    }

    private static void printTriangleComparingResult(double s1, double s2) {
      if (s1 > s2) {
        System.out.println("The 1st triangle with is bigger than the 2nd");
      } else if (s1 < s2) {
        System.out.println("The 1st triangle is smaller than the 2nd");
      } else {
        System.out.println("The 1st triangle is equal to the 2nd");
      }
    }

    public static void main(String[] args) {

      int[][] legs1 = {{5, 5}, {4, 4}, {7, 9}, {12, 13}};
      int[][] legs2 = {{4, 6}, {4, 4}, {6, 10}, {11, 14}};

      System.out.println(getTriangleArea(7, 8));

      for (int i = 0; i < legs1.length; i++) {
        double s1 = getTriangleArea(legs1[i][0], legs1[i][1]);
        double s2 = getTriangleArea(legs2[i][0], legs2[i][1]);
        printTriangleComparingResult(s1, s2);
      }

    }
  }

