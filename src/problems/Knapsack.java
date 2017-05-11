package problems;

import org.junit.Test;

public class Knapsack
{
  static int[] values = new int[] {894, 260, 392, 281, 27};
  static int[] weights = new int[] {8, 6, 4, 0, 21};
  static int W = 30;

  private static int knapsack(int i, int W) {
    if (i < 0) {
      return 0;
    }
    if (weights[i] > W) {
      return knapsack(i-1, W);
    } else {
      return Math.max(knapsack(i-1, W), knapsack(i-1, W - weights[i]) + values[i]);
    }
  }

  @Test
  public void test()
  {
    System.out.println(knapsack(values.length - 1, W));
  }

}
