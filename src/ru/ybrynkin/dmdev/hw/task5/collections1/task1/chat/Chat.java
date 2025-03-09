package ru.ybrynkin.dmdev.hw.task5.collections1.task1.chat;

public class Chat implements Comparable<Chat> {

  private String name;
  private int users;

  public Chat(String name, int users) {
    this.name = name;
    this.users = users;
  }

  public String getName() {
    return name;
  }

  public int getUsers() {
    return users;
  }

  @Override
  public String toString() {
    return "Chat{name='" + name + "', users=" + users + "}";
  }

  @Override
  public int compareTo(Chat other) {
    return this.name.compareTo(other.name); // Natural ordering by name (alphabetical)
  }
}
