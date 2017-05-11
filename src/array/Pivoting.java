package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Pivoting
{
  
  @Test
  public void test()
  {
    int pivotIndex = 2;
    int[] arrayInt = new int[] {
      0,1,2,0,2,1,1,10,-5,1,3,2
    };
    int pivotNumber = arrayInt[pivotIndex];
    System.out.println("init: "+Arrays.toString(arrayInt));
    pivotNew(arrayInt, pivotIndex);
    System.out.print("pivot: "+pivotNumber+", ordered: "+Arrays.toString(arrayInt));

  }

  private void pivotNew(int[] arrayInt, int pivotIndex)
  {
    int pivot = arrayInt[pivotIndex];
    int smaller =0;
    int equal = 0;
    int larger = arrayInt.length-1;
    while (equal<larger)
    {
      if(arrayInt[equal]==pivot){
        equal++;
      }
      if(arrayInt[equal]<pivot) {
        int temp = arrayInt[smaller];
        arrayInt[smaller] = arrayInt[equal];
        arrayInt[equal] = temp;
        equal++;
        smaller++;
      }
      if(arrayInt[equal]>pivot) {
        int temp = arrayInt[larger];
        arrayInt[larger] = arrayInt[equal];
        arrayInt[equal] = temp;
        larger--;
      }

    }
  }

  private void pivot(int[] arrayInt, int pivotIndex)
  {
    int pivot = arrayInt[pivotIndex];
    int index=0;
    int nextSmaller=0;
    while(index<arrayInt.length)
    {
      if(arrayInt[index]<pivot){
        int temp = arrayInt[nextSmaller];
        arrayInt[nextSmaller] = arrayInt[index];
        arrayInt[index] = temp;
        nextSmaller++;
        System.out.println(Arrays.toString(arrayInt));

      }
      index++;
    }

    index = arrayInt.length-1;
    int lowerBigger = arrayInt.length-1;
    while (index>=nextSmaller)
    {
      if(arrayInt[index]>pivot)
      {
        int temp = arrayInt[lowerBigger];
        arrayInt[lowerBigger] = arrayInt[index];
        arrayInt[index] = temp;
        lowerBigger--;
      }
      index--;
    }
  }
}
