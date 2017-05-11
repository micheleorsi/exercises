package interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by morsi on 21/04/2017.
 */
public class ReadingArticle
{

  int readingArticles(int[] intellectual, int[] pages, int p) {
    return this.knapsack(intellectual, pages,intellectual.length-1,p);
  }

  private static int knapsack(int[] values, int[] weights, int i, int W) {
    if (i < 0) {
      return 0;
    }
    if (weights[i] > W) {
      return knapsack(values,weights,i-1, W);
    } else {
      return Math.max(knapsack(values,weights,i-1, W), knapsack(values,weights,i-1, W - weights[i]) + values[i]);
    }
  }

  @Test
  public void test0() {
    Assert.assertEquals(4, readingArticles(new int[]{
      3, 2,2
    }, new int[] {
      3,2,2
    },9));
  }

  @Test
  public void test1() {
    Assert.assertEquals(4, readingArticles(new int[]{
      1, 4,6,3
    }, new int[] {
      1,2,23
    },8));
  }

  @Test
  public void test2() {
    Assert.assertEquals(4, readingArticles(new int[]{
      1, 4,2,5,3
    }, new int[] {
      4,12,8,14,2
    },13));
  }

}
