package ru.ybrynkin.dmdev.hw.task7.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import ru.ybrynkin.dmdev.hw.task7.csv.model.ItemName;
import ru.ybrynkin.dmdev.hw.task7.csv.model.ItemPrice;

public class CsvReader {

  private static final int EXPECTED_PRICE_COLUMNS = 2;
  private static final int MIN_NAME_COLUMNS = 2;

  public static InputStream getInputStream(Path csvPath) throws IOException {
    return Files.newInputStream(csvPath);
  }

  public static List<ItemPrice> readPrices(InputStream inputStream) throws IOException {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

      return reader.lines()
          .skip(1) // Skip header
          .map(line -> line.split(","))
          .filter(parts -> {
            if (parts.length != EXPECTED_PRICE_COLUMNS) {
              System.err.println("Skipping malformed price line: " + Arrays.toString(parts));
              return false;
            }
            return true;
          })
          .map(parts -> {
            try {
              return new ItemPrice(
                  Integer.parseInt(parts[0].trim()),
                  parts[1].trim());
            } catch (NumberFormatException e) {
              System.err.println("Invalid ID format in price data: " + parts[0]);
              return null;
            }
          })
          .filter(Objects::nonNull)
          .collect(Collectors.toList());
    }
  }

  public static List<ItemName> readNames(InputStream inputStream) throws IOException {
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

      return reader.lines()
          .skip(1) // Skip header
          .map(line -> line.split(",", 3)) // Split into max 3 parts
          .filter(parts -> {
            if (parts.length < MIN_NAME_COLUMNS) {
              System.err.println("Skipping malformed name line: " + Arrays.toString(parts));
              return false;
            }
            return true;
          })
          .map(parts -> {
            try {
              return new ItemName(
                  Integer.parseInt(parts[0].trim()),
                  parts[1].trim(),
                  parts.length > 2 ? parts[2].trim() : "");
            } catch (NumberFormatException e) {
              System.err.println("Invalid ID format in name data: " + parts[0]);
              return null;
            }
          })
          .filter(Objects::nonNull)
          .collect(Collectors.toList());
    }
  }

  public static List<ItemPrice> readPricesFromPath(Path csvPath) throws IOException {
    try (InputStream inputStream = getInputStream(csvPath)) {
      return readPrices(inputStream);
    }
  }

  public static List<ItemName> readNamesFromPath(Path csvPath) throws IOException {
    try (InputStream inputStream = getInputStream(csvPath)) {
      return readNames(inputStream);
    }
  }
}
