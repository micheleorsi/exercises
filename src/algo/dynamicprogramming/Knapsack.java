package algo.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class Knapsack
{

  private int knapsack(int index, int[] values, int[] weights, int actualW) {
    if(actualW==0 || index<0) {
      return 0;
    }
    if (weights[index] > actualW) {
      return knapsack(index-1, values, weights, actualW);
    } else {
      return Math.max(
              knapsack(index-1, values, weights, actualW - weights[index]) + values[index],
              knapsack(index-1, values, weights, actualW)
      );
    }
  }

  private int knapsackMem(int[] values, int[] weights, int maxWeight) {
    int[][] K = new int[values.length+1][maxWeight+1];

    for (int valIdx = 0; valIdx <= values.length; valIdx++)
    {
      for (int w = 0; w <= maxWeight; w++)
      {
        if (valIdx==0 || w==0)
          K[valIdx][w] = 0;
        else if (weights[valIdx-1] <= w)
          K[valIdx][w] = Math.max(
                  values[valIdx-1] + K[valIdx-1][w-weights[valIdx-1]],
                  K[valIdx-1][w]
          );
        else
          K[valIdx][w] = K[valIdx-1][w];
      }
    }
    return K[values.length][maxWeight];
  }

  @Test
  public void test()
  {
    int[] values = new int[] {894, 260, 392, 281, 27};
    int[] weights = new int[] {8, 6, 4, 0, 21};

    Assert.assertEquals(1827,knapsack(values.length - 1,values,weights, 30));
    Assert.assertEquals(0,knapsack(values.length - 1, values,weights,0));
    Assert.assertEquals(0,knapsack(0, values,weights,7));
    Assert.assertEquals(392+281,knapsack(values.length - 1, values,weights,7));
    Assert.assertEquals(894,knapsack(0, values,weights,8));
    Assert.assertEquals(894+281,knapsack(values.length - 1, values,weights,8));

    Assert.assertEquals(1827,knapsackMem(values,weights, 30));
    Assert.assertEquals(0,knapsackMem(values,weights,0));
    Assert.assertEquals(392+281,knapsackMem(values,weights,7));
    Assert.assertEquals(894+281,knapsackMem(values,weights,8));
  }

}
