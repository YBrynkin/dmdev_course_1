package ru.ybrynkin.dmdev.hw.task5.collections1.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import ru.ybrynkin.dmdev.hw.task5.collections1.task1.chat.Chat;

public class ChatRunner {

  public static void main(String[] args) {
    // Create a list of chats
    List<Chat> chats = new ArrayList<>();
    chats.add(new Chat("General", 1500));
    chats.add(new Chat("Random", 700));
    chats.add(new Chat("Trash", 2500));
    chats.add(new Chat("Memes Lovers", 1200));
    chats.add(new Chat("Gaming", 350));
    chats.add(new Chat("Movies and music", 1500));

    // Remove chats with less than 1000 users using an iterator
    Iterator<Chat> iterator = chats.iterator();
    while (iterator.hasNext()) {
      Chat chat = iterator.next();
      if (chat.getUsers() < 1000) {
        iterator.remove();
      }
    }

    // Sort the remaining chats by users (descending) and name(alphabetical)
    Collections.sort(chats,
        new Comparator<Chat>() {
          @Override
          public int compare(Chat chat1, Chat chat2) {
            if (chat1.getUsers() != chat2.getUsers()) {
              return Integer.compare(chat2.getUsers(), chat1.getUsers()); // Descending order
            } else {
              return chat1.getName().compareTo(chat2.getName()); // Alphabetical order
            }
          }
        });

    // Print the sorted list
    System.out.println("Sorted by users (descending) and name (alphabetical):");
    for (Chat chat : chats) {
      System.out.println(chat);
    }

    // Sort the chats by name (natural ordering using Comparable)
    Collections.sort(chats);

    // Print the sorted list
    System.out.println("\nSorted by name (natural ordering):");
    for (Chat chat : chats) {
      System.out.println(chat);
    }

  }

}
