package hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Smarkets
{

  public int segment(int x, int[] array){
    return -1;
  }

  public int findMinimum(int[] array) {
    int min = Integer.MAX_VALUE;
    for(int i=0; i<array.length; i++)
    {
      if(array[i]<min) {
        min = array[i];
      }
    }
    return min;
  }

  public int findMaximum(int[] array) {
    int max = Integer.MIN_VALUE;
    for(int i=0; i<array.length; i++)
    {
      if(array[i]>max) {
        max = array[i];
      }
    }
    return max;
  }

  @Test
  public void min1()
  {
    Assert.assertEquals(findMinimum(new int[]{0,1,10}),0);
    Assert.assertEquals(findMinimum(new int[]{}),Integer.MAX_VALUE);
    Assert.assertEquals(findMinimum(new int[]{-100,23,90}),-100);
  }

  @Test
  public void max()
  {
    Assert.assertEquals(findMaximum(new int[]{0,1,10}),10);
    Assert.assertEquals(findMaximum(new int[]{}),Integer.MIN_VALUE);
    Assert.assertEquals(findMaximum(new int[]{-100,23,90}),90);
  }



  @Test
  public void sample1()
  {
    Assert.assertEquals(3, segment(1,new int[]{1,2,3,1,2}));
  }

  @Test
  public void sample2()
  {
    Assert.assertEquals(1, segment(2,new int[]{1,1,1}));
  }

  @Test
  public void sample3()
  {
    Assert.assertEquals(4, segment(3,new int[]{2,5,4,6,8}));

  }

  @Test
  public void sample4()
  {
    Assert.assertEquals(1, segment(1,new int[]{1}));

  }
}

