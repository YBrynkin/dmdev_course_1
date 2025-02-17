package ru.ybrynkin.dmdev.hw.task3.strings;

import java.util.Arrays;

public class Task2 {

  /**
   * Задание 2
   * Дана строка с текстом, в котором есть цифры от 0 до 9. Написать 2 метода:
   * - возвращающий массив цифр из переданной строки;
   * - возвращающий сумму цифр из переданного целочисленного массива.
   * Посчитать сумму всех чисел из строки
   * Например: “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
   */

  private static final String NUMBERS = "0123456789";

  private static int[] getNumsArray(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      String currChar = String.valueOf(str.charAt(i));
      if (NUMBERS.contains(currChar)) {
        sb.append(currChar);
      }
    }

    int[] nums = new int[sb.length()];
    for (int i = 0; i < sb.length(); i++) {
      nums[i] = Integer.parseInt(String.valueOf(sb.charAt(i)));
    }
    return nums;
  }

  private static int getTotalSum(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }
    return sum;
  }

  public static void main(String[] args) {
    String test = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";
    System.out.println(Arrays.toString(getNumsArray(test)));
    System.out.println(getTotalSum(getNumsArray(test)));
  }

}
