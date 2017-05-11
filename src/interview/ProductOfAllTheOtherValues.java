package interview;

import org.junit.Assert;
import org.junit.Test;

public class ProductOfAllTheOtherValues
{
  int[] array = new int[] {3, 4, 5, 6, 8};

  @Test
  public void test()
  {
    int[] product = calculateNoDivision(array);
    Assert.assertEquals(4 * 5 * 6 * 8, product[0]);
    Assert.assertEquals(3 * 5 * 6 * 8, product[1]);
    Assert.assertEquals(3 * 4 * 6 * 8, product[2]);
    Assert.assertEquals(3 * 4 * 5 * 8, product[3]);
    Assert.assertEquals(3 * 4 * 5 * 6, product[4]);
  }

  private int[] calculateNoDivision(int[] array)
  {
    int[] returnArray = new int[array.length];

    int[] upperArray = new int[array.length];
    int[] lowerArray = new int[array.length];

    int totalProduct = 1;
    for(int i=0; i<array.length; i++)
    {
      upperArray[i] = totalProduct;
      totalProduct*=array[i];
    }
    totalProduct = 1;
    for(int i=array.length-1; i>=0; i--)
    {
      lowerArray[i] = totalProduct;
      totalProduct*=array[i];
    }

    for(int i=0; i<array.length; i++)
    {
      returnArray[i] = upperArray[i] * lowerArray[i];
    }

    return returnArray;
  }

  private int[] calculateFast(int[] array)
  {
    int[] returnArray = new int[array.length];
    int totalProduct = 1;
    for(int i=0; i<array.length; i++)
    {
      totalProduct*=array[i];
    }
    for(int i=0; i<array.length; i++)
    {
      returnArray[i]=totalProduct/array[i];
    }
    return returnArray;
  }

  private int[] calculate(int[] array)
  {
    int[] returnArray = new int[array.length];
    for(int i=0; i<array.length; i++)
    {
      int total = 1;
      for(int j=0; j<array.length; j++)
      {
        if(j!=i){
          total*=array[j];
        }
      }
      returnArray[i] = total;
    }
    return returnArray;
  }
}
