package m6_1_hashmap_to_treemap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine().trim();

    // Remove outer curly braces
    input = input.substring(1, input.length() - 1).trim();

    Map<String, Integer> hashMap = new HashMap<>();

    if (!input.isEmpty()) {
      String[] pairs = input.split(",");

      for (String pair : pairs) {
        String[] keyValue = pair.split("->");
        String key = keyValue[0].trim().replace("\"", "");
        int value = Integer.parseInt(keyValue[1].trim());
        hashMap.put(key, value);
      }
    }

    // Convert to TreeMap (sorted by key)
    TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);

    // Format and print output exactly as required
    StringBuilder output = new StringBuilder();
    output.append("{ ");
    boolean first = true;
    for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
      if (!first) {
        output.append(", ");
      }
      output.append("\"").append(entry.getKey()).append("\" -> ").append(entry.getValue());
      first = false;
    }
    output.append(" }");

    System.out.println(output.toString());
    sc.close();
  }
}