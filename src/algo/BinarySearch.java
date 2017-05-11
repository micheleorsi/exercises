package algo;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch
{

  private int binarysearch(int[] array, int number)
  {
    int iterative = bsiterative(array,number);
    int recursive = bsrecursive(array,0,array.length-1,number);
    if( iterative!=recursive)
    {
      throw new RuntimeException("different");
    }
    else {
      return iterative;
    }
  }

  private int bsiterative(int[] array, int number) {
    int startIdx = 0;
    int endIdx = array.length-1;

    while(startIdx<=endIdx){
      int mid = (startIdx+endIdx)/2;
      if(array[mid]==number) {
        return mid;
      } else if(array[mid]>number) {
        endIdx = mid-1;
      } else if(array[mid]<number) {
        startIdx = mid+1;
      }
    }
    return -1;
  }

  private int bsrecursive(int[] array, int initIdx, int lastIdx, int number)
  {
    int middlePosition = (lastIdx + initIdx)/2;
    if (lastIdx<initIdx) {
      return -1;
    }
    if(array[middlePosition] == number) {
      return middlePosition;
    } else if (array[middlePosition] > number)
    {
      return bsrecursive(array, initIdx, middlePosition-1, number);
    }
    else
    {
      return bsrecursive(array, middlePosition+1, lastIdx, number);
    }
  }

  @Test
  public void test()
  {
    int[] array = new int[]{1, 2, 3, 4, 5, 7, 8};
    Assert.assertEquals(0,binarysearch(array,1));
    Assert.assertEquals(1,binarysearch(array,2));
    Assert.assertEquals(2,binarysearch(array,3));
    Assert.assertEquals(3,binarysearch(array,4));
    Assert.assertEquals(4,binarysearch(array,5));
    Assert.assertEquals(-1,binarysearch(array,6));
    Assert.assertEquals(5,binarysearch(array,7));
    Assert.assertEquals(6,binarysearch(array,8));
    Assert.assertEquals(-1,binarysearch(array,10));
    Assert.assertEquals(-1,binarysearch(array,30));
    Assert.assertEquals(-1,binarysearch(array,40));
    Assert.assertEquals(-1,binarysearch(array,0));

  }
}
