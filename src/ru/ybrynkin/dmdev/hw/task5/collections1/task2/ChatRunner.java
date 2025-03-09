package ru.ybrynkin.dmdev.hw.task5.collections1.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import ru.ybrynkin.dmdev.hw.task5.collections1.task2.chat.Chat;
import ru.ybrynkin.dmdev.hw.task5.collections1.task2.chat.User;

public class ChatRunner {

  public static void main(String[] args) {
    // Create a list of chats with users
    List<Chat> chats = new ArrayList<>();
    chats.add(new Chat("General", Arrays.asList(
        new User(1, "Andrew", 25),
        new User(2, "Artem", 17),
        new User(3, "Ivan", 30)
    )));
    chats.add(new Chat("Random", Arrays.asList(
        new User(4, "Dima", 16),
        new User(5, "Pavel", 22),
        new User(6, "Nikita", 19)
    )));
    chats.add(new Chat("Trash", Arrays.asList(
        new User(7, "Egor", 20),
        new User(8, "Eva", 15),
        new User(9, "Helena", 28)
    )));

    // Convert the chat list into a single list of users over 18
    List<User> usersOver18 = new ArrayList<>();
    for (Chat chat : chats) {
      for (User user : chat.getUsers()) {
        if (user.getAge() > 18) {
          usersOver18.add(user);
        }
      }
    }

    // Print the list of users over 18
    System.out.println("Users over 18:");
    for (User user : usersOver18) {
      System.out.println(user);
    }

    double averageAge = getAverageAge(usersOver18);

    // Print the average age
    System.out.println("\nAverage age of users over 18: " + averageAge);
  }

  private static double getAverageAge(List<User> usersOver18) {
    // Use an iterator to calculate the average age of all remaining users
    Iterator<User> iterator = usersOver18.iterator();
    int totalAge = 0;
    int count = 0;

    while (iterator.hasNext()) {
      User user = iterator.next();
      totalAge += user.getAge();
      count++;
    }

    return (count == 0) ? 0 : (double) totalAge / count;
  }

}
