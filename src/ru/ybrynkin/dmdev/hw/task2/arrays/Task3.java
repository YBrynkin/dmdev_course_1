package ru.ybrynkin.dmdev.hw.task2.arrays;

import java.util.Arrays;

public class Task3 {

  /**
   * Задание 3
   *
   * Дан одномерный массив целых чисел.
   *
   * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только
   * отрицательными числами, только положительными и только нули. Если для какого-то из массивов не
   * будет значений, то должен быть создан пустой массив. Возвращает функция эти три массива в виде
   * одного двумерного.
   *
   * Пример:
   * [-4, 0, 1, 9, 0, -18, 3] -> {[-4, -18], [0, 0], [1, 9, 3]}
   */


  private static int[][] getProcessedArrays(int[] nums) {
    int[][] processedArrays = new int[3][];
    StringBuilder tempPositives = new StringBuilder();
    StringBuilder tempZeros = new StringBuilder();
    StringBuilder tempNegatives = new StringBuilder();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        tempPositives.append(nums[i]).append(" ");
      } else if (nums[i] < 0) {
        tempNegatives.append(nums[i]).append(" ");
      } else {
        tempZeros.append(nums[i]).append(" ");
      }
    }
    int[] positives = getNumsArrayFromString(tempPositives.toString().trim());
    int[] negatives = getNumsArrayFromString(tempNegatives.toString().trim());
    int[] zeros = getNumsArrayFromString(tempZeros.toString().trim());

    processedArrays[0] = positives;
    processedArrays[1] = negatives;
    processedArrays[2] = zeros;

    return processedArrays;
  }

  private static int[] getNumsArrayFromString(String tempNumsString) {
    if (tempNumsString.length() > 0) {
      String[] tempNums = tempNumsString.split(" ");
      int[] nums = new int[tempNums.length];
      for (int i = 0; i < tempNums.length; i++) {
        nums[i] = Integer.parseInt(tempNums[i]);
      }
      return nums;
    } else {
      return new int[0];
    }
  }

  public static void main(String[] args) {
    int[][] test = getProcessedArrays(new int[] {-4, -2, 1, 9, -1, -18, 3});
    for (int i = 0; i < test.length; i++) {
      System.out.println(Arrays.toString(test[i]));
    }
  }

}
