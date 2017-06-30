package algo.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class SortingTest
{
  int[] noDuplicates, duplicates;

  public void init()
  {
    noDuplicates = new int[] {
            10,2,3,4,20,5,9,13
    };
    duplicates = new int[] {
            10,2,3,4,20,5,9,13,10,2,3
    };
  }

  private boolean assertOrdered(int[] array)
  {
    boolean isOrdered = true;
    for(int i=1; i<array.length; i++)
    {
      if(array[i]<array[i-1])
        return false;
    }
    return isOrdered;
  }

  @Test
  public void test()
  {
    init();
    Assert.assertFalse(assertOrdered(noDuplicates));
    Assert.assertFalse(assertOrdered(duplicates));
    new BubbleSort().sort(noDuplicates);
    new BubbleSort().sort(duplicates);
    Assert.assertTrue(assertOrdered(noDuplicates));
    Assert.assertTrue(assertOrdered(duplicates));

    init();
    Assert.assertFalse(assertOrdered(noDuplicates));
    Assert.assertFalse(assertOrdered(duplicates));
    new SelectionSort().sort(noDuplicates);
    new SelectionSort().sort(duplicates);
    Assert.assertTrue(assertOrdered(noDuplicates));
    Assert.assertTrue(assertOrdered(duplicates));

  }
}
