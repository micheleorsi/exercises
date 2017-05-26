package algo.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SelectionSort
{
  @Test
  public void test()
  {
    int[] arr = {2,1,6,4,0,3,10,2,2,2,2};
    sort(arr);
    System.out.println(Arrays.toString(arr));
    for(int i=1; i<arr.length; i++)
    {
      Assert.assertTrue(arr[i]>=arr[i-1]);
    }
  }

  public void sort(int[] array)
  {
    for(int i=0; i<array.length; i++)
    {
      for(int j=i+1; j<array.length; j++)
      {
        if(array[j]<array[i])
        {
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
  }
}
