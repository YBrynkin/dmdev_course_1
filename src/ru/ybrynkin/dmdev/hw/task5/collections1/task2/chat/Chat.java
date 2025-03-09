package ru.ybrynkin.dmdev.hw.task5.collections1.task2.chat;

import java.util.List;

public class Chat {

  private String name;
  private List<User> users;

  public Chat(String name, List<User> users) {
    this.name = name;
    this.users = users;
  }

  public String getName() {
    return name;
  }

  public List<User> getUsers() {
    return users;
  }

  @Override
  public String toString() {
    return "Chat{name='" + name + "', users=" + users + "}";
  }
}
