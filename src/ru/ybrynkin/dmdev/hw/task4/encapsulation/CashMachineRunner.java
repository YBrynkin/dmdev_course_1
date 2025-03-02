package ru.ybrynkin.dmdev.hw.task4.encapsulation;

import ru.ybrynkin.dmdev.hw.task4.encapsulation.cashmachine.CashMachine;

public class CashMachineRunner {

  public static void main(String[] args) {
    CashMachine cm = new CashMachine(10,0,1);
    cm.withdrawMoney(18);
    cm.withdrawMoney(10);
    cm.withdrawMoney(20);
    cm.withdrawMoney(60);
    cm.withdrawMoney(100);

    cm.addTwenties(3);
    cm.withdrawMoney(40);
    System.out.println(cm);
  }

}
