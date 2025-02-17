package ru.ybrynkin.dmdev.hw.task2.arrays;

import java.util.Arrays;

public class Task1 {

  /**
   * Задание 1
   * Дан одномерный массив целых чисел. Написать функцию, удаляющую из него все
   * отрицательные элементы (удалить - значит создать новый массив с только положительными
   * элементами). После удаления - умножить каждый элемент массива на его длину. Например: [3, 5,
   * -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
   */

  private static int[] processIntegerArray(int[] nums) {
    String tempPositiveNums = getPositiveNumsString(nums);
    return getUpdatedNums(tempPositiveNums);
  }

  private static int[] getUpdatedNums(String tempPositiveNums) {
    String[] tempPositiveNumsArray = tempPositiveNums.split(" ");
    int[] updatedNums = new int[tempPositiveNumsArray.length];
    for (int i = 0; i < tempPositiveNumsArray.length; i++) {
      updatedNums[i] = Integer.parseInt(tempPositiveNumsArray[i]) * tempPositiveNumsArray.length;
    }
    return updatedNums;
  }

  private static String getPositiveNumsString(int[] nums) {
    StringBuilder sb = new StringBuilder();
    for (int num : nums) {
      if (num >= 0) {
        sb.append(num).append(" ");
      }
    }
    return sb.toString().trim();
  }

  public static void main(String[] args) {
    int[] test = {3, 5, -6, 3, 2, -9, 0, -123};
    System.out.println(Arrays.toString(processIntegerArray(test)));
  }
}
