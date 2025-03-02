package ru.ybrynkin.dmdev.hw.task4.encapsulation.cashmachine;

/**
 * Задание 1
 * <p>
 * Создать класс, описывающий банкомат.
 * <p>
 * Банкомат задается тремя свойствами: - количеством купюр номиналом 10, 20 и 50.
 * <p>
 * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
 * <p>
 * Сделать методы для добавления денег в банкомат.
 * <p>
 * Сделать метод, снимающий деньги: он принимает сумму денег, а возвращает булево значение -
 * успешность выполнения операции.
 * <p>
 * При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся
 * сумма.
 * <p>
 * Сначала банкомат будет пытаться рассчитаться 50, далее добавит недостающие 20, и только затем 10
 * (не нужно рассматривать более сложные варианты выдачи наличных, чтобы не усложнять алгоритм).
 */

public class CashMachine {

  //Determine denominations of the notes
  private final static int TEN_DOLLARS = 10;
  private final static int TWENTY_DOLLARS = 20;
  private final static int FIFTY_DOLLARS = 50;

  //Counts of determined notes
  private int twentiesCount;
  private int tensCount;
  private int fiftiesCount;

  public CashMachine(int tensCount, int twentiesCount, int fiftiesCount) {
    if (tensCount >= 0 || twentiesCount >= 0 || fiftiesCount >= 0) {
      this.tensCount = tensCount;
      this.twentiesCount = twentiesCount;
      this.fiftiesCount = fiftiesCount;
    } else {
      throw new IllegalArgumentException();
    }
  }

  //Add tens
  public void addTens(int tens) {
    if (tens > 0) {
      this.tensCount += tens;
    } else {
      throw new IllegalArgumentException();
    }
  }

  //Add twenties
  public void addTwenties(int twenties) {
    if (twenties > 0) {
      this.twentiesCount += twenties;
    } else {
      throw new IllegalArgumentException();
    }
  }

  //Add fifties
  public void addFifties(int fifties) {
    if (fifties > 0) {
      this.fiftiesCount += fifties;
    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("CashMachine{");
    sb.append("twentiesCount=").append(twentiesCount);
    sb.append(", tensCount=").append(tensCount);
    sb.append(", fiftiesCount=").append(fiftiesCount);
    sb.append('}');
    return sb.toString();
  }

  public boolean withdrawMoney(int amount) {
    boolean isPossibleToIssueMoney = false;
    //Check input argument
    if (amount > 0) {
      //Check the possibility to issue required amount
      if (amount % TEN_DOLLARS == 0) {
        //Check fifties
        int fiftiesTaken = amount / FIFTY_DOLLARS;
        if (fiftiesTaken > 0 && fiftiesTaken <= fiftiesCount) {
          isPossibleToIssueMoney = true;
          fiftiesCount -= fiftiesTaken;
          amount -= fiftiesTaken * FIFTY_DOLLARS;
          System.out.printf("%d banknotes with a face value of %d dollars were taken from an ATM\n",
              fiftiesTaken, FIFTY_DOLLARS);
        }
        //Check twenties
        int twentiesTaken = amount / TWENTY_DOLLARS;
        if (twentiesTaken > 0 && twentiesTaken <= twentiesCount) {
          isPossibleToIssueMoney = true;
          twentiesCount -= twentiesTaken;
          amount -= twentiesTaken * TWENTY_DOLLARS;
          System.out.printf("%d banknotes with a face value of %d dollars were taken from an ATM\n",
              twentiesTaken, TWENTY_DOLLARS);
        }
        //Check tens
        int tensTaken = amount / TEN_DOLLARS;
        if (tensTaken > 0 && tensTaken <= tensCount) {
          isPossibleToIssueMoney = true;
          tensCount -= tensTaken;
          amount -= tensTaken * TEN_DOLLARS;
          System.out.printf("%d banknotes with a face value of %d dollars were taken from an ATM\n",
              tensTaken, TEN_DOLLARS);
        }
        if (!isPossibleToIssueMoney) {
          System.out.println("Impossible to withdraw money!");
        }
        return isPossibleToIssueMoney;
      } else {
        System.out.println("Impossible to withdraw money!");
        return false;
      }
    } else {
      throw new IllegalArgumentException();
    }


  }

}
