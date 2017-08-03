package algo.sort;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortingTest
{
  int[][] standard;
  int[][] edges;

  public void init()
  {
    standard = new int[][] {
      new int[] {10,2,3,4,20,5,9,13},
      new int[] {10,2,3,4,20,5,9,13,10,2,3}, // duplicates
      new int[] {8,7,6,5,4,3,2,1} // reverse order
    };
    edges = new int[][] {
      new int[]{},
      new int[]{1}
    };
  }

  private boolean isAscendingOrdered(int[] array)
  {
    boolean isOrdered = true;
    for(int i=1; i<array.length; i++)
    {
      if(array[i]<array[i-1])
        return false;
    }
    return isOrdered;
  }

  @Before
  public void before()
  {
    init();
    for(int[] array: standard)
    {
      Assert.assertFalse(isAscendingOrdered(array));
    }
  }

  @After
  public void after()
  {
    for(int[] array: standard)
    {
      Assert.assertTrue(isAscendingOrdered(array));
    }
  }

  @Test
  public void BubbleSort() {
    for(int[] array: standard)
    {
      new BubbleSort().sort(array);
    }
    for(int[] array: edges)
    {
      new BubbleSort().sort(array);
    }
  }

  @Test
  public void SelectionSort() {
    for(int[] array: standard)
    {
      new SelectionSort().sort(array);
    }
    for(int[] array: edges)
    {
      new SelectionSort().sort(array);
    }
  }

  @Test
  public void InsertionSort() {
    for(int[] array: standard)
    {
      new InsertionSort().sort(array);
    }
    for(int[] array: edges)
    {
      new InsertionSort().sort(array);
    }
  }

  @Test
  public void QuickSort() {
    for(int[] array: standard)
    {
      new QuickSort().sort(array);
    }
    for(int[] array: edges)
    {
      new QuickSort().sort(array);
    }
  }

  @Test
  public void MergeSort() {
    for(int[] array: standard)
    {
      new MergeSort().sort(array);
    }
    for(int[] array: edges)
    {
      new MergeSort().sort(array);
    }
  }
}
