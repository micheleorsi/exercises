package algo.sort;

import org.junit.Test;

import java.util.Arrays;

public class InsertionSort
{
  @Test
  public void test()
  {
    int[] arr = {2,1,6,4,0,3};

    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public void sort(int[] array)
  {
    for(int i=1; i<array.length; i++)
    {
      for(int j=0; j<i; j++)
      {
        if(array[i]<array[j])
        {
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }

    }

  }
}
