package ru.ybrynkin.dmdev.hw.task3.strings;

public class Task1 {

  /**
   * Задание 1
   * Дана строка. Удалить из нее все повторяющиеся символы без учета регистра, если они
   * идут друг за другом. Также удалить пробелы. Результат привести к верхнему регистру.
   * Например: "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
   */

  private static final String SPACE = " ";

  private static String processString(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      String currChar = String.valueOf(str.charAt(i)).toUpperCase();
      if (!sb.toString().contains(currChar) && !currChar.equals(SPACE)) {
        sb.append(currChar);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String test = "abc Cpddd Dio OsfWw";
    System.out.println(processString(test));
  }

}
