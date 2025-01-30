package m2_2_stock_span;

import java.util.Arrays;

public class Main {

  public int[] calculateSpan(int[] stockPrices) {
    int n = stockPrices.length;
    int[] span = new int[n];

    span[0] = 1; // The span of the first day is always 1.

    for (int i = 1; i < n; i++) {
      span[i] = 1; // Initialize the span for the current day.
      int j = i - 1;

      while (j >= 0 && stockPrices[i] >= stockPrices[j]) {
        span[i]++;
        j--;
      }
    }

    return span;
  }

  public static void main(String[] args) {
    Main calculator = new Main();
    int[] stockPrices = { 100, 80, 60, 70, 60, 75, 85 };
    int[] spans = calculator.calculateSpan(stockPrices);

    System.out.println("Stock Prices: " + Arrays.toString(stockPrices));
    System.out.println("Stock Spans:   " + Arrays.toString(spans));
  }
}