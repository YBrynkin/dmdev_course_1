package ru.ybrynkin.dmdev.hw.task7.csv;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import ru.ybrynkin.dmdev.hw.task7.csv.model.ItemName;
import ru.ybrynkin.dmdev.hw.task7.csv.model.ItemPrice;
import ru.ybrynkin.dmdev.hw.task7.csv.model.MergedItem;

public class CsvMerger {

  public static void mergeFiles(Path pricePath, Path namePath,
      Path resultPath, Path errorPath) throws IOException {

    // Read data using the new path-based methods
    List<ItemPrice> prices = CsvReader.readPricesFromPath(pricePath);
    List<ItemName> names = CsvReader.readNamesFromPath(namePath);

    // Process data
    Map<Integer, String> priceMap = prices.stream()
        .collect(Collectors.toMap(ItemPrice::getId, ItemPrice::getPrice));

    Map<Integer, ItemName> nameMap = names.stream()
        .collect(Collectors.toMap(ItemName::getId, item -> item));

    Set<Integer> allIds = new HashSet<>();
    allIds.addAll(priceMap.keySet());
    allIds.addAll(nameMap.keySet());

    List<MergedItem> mergedItems = new ArrayList<>();
    List<Integer> errorIds = new ArrayList<>();

    for (Integer id : allIds.stream().sorted().collect(Collectors.toList())) {
      if (priceMap.containsKey(id) && nameMap.containsKey(id)) {
        mergedItems.add(new MergedItem(
            id,
            nameMap.get(id).getName(),
            priceMap.get(id)));
      } else {
        errorIds.add(id);
      }
    }

    // Write output
    CsvWriter.writeMergedItems(resultPath, mergedItems);
    CsvWriter.writeErrorIds(errorPath, errorIds);
  }
}

