package ru.ybrynkin.dmdev.hw.task7.csv;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import ru.ybrynkin.dmdev.hw.task7.csv.model.MergedItem;

public class CsvWriter {
  public static void writeMergedItems(Path outputPath, List<MergedItem> items) throws IOException {
    try (BufferedWriter writer = Files.newBufferedWriter(outputPath,
        StandardCharsets.UTF_8,
        StandardOpenOption.CREATE,
        StandardOpenOption.TRUNCATE_EXISTING)) {

      writer.write("ID,NAME,PRICE");
      writer.newLine();

      for (MergedItem item : items) {
        writer.write(String.format("%d,%s,%s",
            item.getId(),
            escapeCsvField(item.getName()),
            escapeCsvField(item.getPrice())));
        writer.newLine();
      }
    }
  }

  public static void writeErrorIds(Path outputPath, List<Integer> errorIds) throws IOException {
    try (BufferedWriter writer = Files.newBufferedWriter(outputPath,
        StandardCharsets.UTF_8,
        StandardOpenOption.CREATE,
        StandardOpenOption.TRUNCATE_EXISTING)) {

      writer.write("ID");
      writer.newLine();

      for (Integer id : errorIds) {
        writer.write(id.toString());
        writer.newLine();
      }
    }
  }

  private static String escapeCsvField(String field) {
    if (field == null) {
      return "";
    }
    // Escape quotes and wrap in quotes if contains comma
    if (field.contains(",") || field.contains("\"")) {
      return "\"" + field.replace("\"", "\"\"") + "\"";
    }
    return field;
  }
}