package ru.ybrynkin.dmdev.hw.task7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import ru.ybrynkin.dmdev.hw.task7.csv.CsvMerger;

public class Main {

  public static void main(String[] args) {
    Path resourceDir = Paths.get("src", "ru", "ybrynkin", "dmdev", "hw", "task7", "resources");
    Path outputDir = Paths.get("src", "ru", "ybrynkin", "dmdev", "hw", "task7", "output");

    try {
      // Create output directory if it doesn't exist
      Files.createDirectories(outputDir);

      // Get input paths
      Path pricePath = resourceDir.resolve("items-price.csv");
      Path namePath = resourceDir.resolve("items-name.csv");

      // Get output paths
      Path resultPath = outputDir.resolve("result.csv");
      Path errorPath = outputDir.resolve("errors.csv");

      // Process files using the simplified merger
      CsvMerger.mergeFiles(pricePath, namePath, resultPath, errorPath);

      System.out.println("CSV files merged successfully!");
      System.out.println("Results saved to: " + resultPath);
      System.out.println("Errors saved to: " + errorPath);

    } catch (IOException e) {
      System.err.println("Error merging CSV files: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
