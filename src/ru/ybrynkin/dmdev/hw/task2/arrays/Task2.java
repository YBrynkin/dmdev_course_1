package ru.ybrynkin.dmdev.hw.task2.arrays;

public class Task2 {

  /**
   * Задание 2
   *
   * Дан одномерный массив символов. Преобразовать его в одномерный массив чисел, где число - это
   * код символа (любой символ - это число в памяти компьютера). Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’,
   * ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
   *
   * Далее определить среднее арифметическое всех элементов целочисленного массива и вывести на
   * консоль только те элементы, которые больше этого среднего арифметического.
   */

  private static void printCharsAboveArithmeticMean(Character[] chars) {
    int mean = getMean(chars);
    System.out.println("The arithmetic mean is: " + mean);
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] > mean) {
        int c = chars[i];
        System.out.println(chars[i] + " " + c + ";");

      }
    }
  }

  private static int getMean(Character[] chars) {
    int sum = 0;
    for (Character aChar : chars) {
      sum += aChar;
    }
    return sum / chars.length;
  }

  public static void main(String[] args) {
    Character[] chars = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};
    printCharsAboveArithmeticMean(chars);
  }

}
