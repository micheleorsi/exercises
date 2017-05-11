package array;

import org.junit.Assert;
import org.junit.Test;

public class EvenEntriesAppearFirst
{

  @Test
  public void test()
  {
    int[] temp = new int[]{
      5,4,7,3,2,0,1
    };
    // ordered: 4,2,0,
    Assert.assertEquals(4, orderEvenMine(temp)[0]);
    Assert.assertEquals(2, orderEvenMine(temp)[1]);
    Assert.assertEquals(0, orderEvenMine(temp)[2]);


    int[] temp2 = new int[]{
      0,19,21,33,42,9,1
    };
    // ordered: 4,2,0,
    Assert.assertEquals(0, orderEvenMine(temp2)[0]);
    Assert.assertEquals(42, orderEvenMine(temp2)[1]);

    int[] temp3 = new int[]{
      1,19,21,33,41,9,1
    };
    // ordered: 4,2,0,
    Assert.assertEquals(1, orderEvenMine(temp3)[0]);
    Assert.assertEquals(19, orderEvenMine(temp3)[1]);
  }

  @Test
  public void test2()
  {
    int[] temp = new int[]{
      5,4,7,3,2,0,1
    };
    // ordered: 4,2,0,
    Assert.assertEquals(0, orderEvenNotStable(temp)[0]);
    Assert.assertEquals(4, orderEvenNotStable(temp)[1]);
    Assert.assertEquals(2, orderEvenNotStable(temp)[2]);


    int[] temp2 = new int[]{
      0,19,21,33,42,9,1
    };
    // ordered: 4,2,0,
    Assert.assertEquals(0, orderEvenNotStable(temp2)[0]);
    Assert.assertEquals(42, orderEvenNotStable(temp2)[1]);

    int[] temp3 = new int[]{
      1,19,21,33,41,9,1
    };
    // ordered: 4,2,0,
    Assert.assertEquals(19, orderEvenNotStable(temp3)[0]);
    Assert.assertEquals(33, orderEvenNotStable(temp3)[1]);
  }

  private int[] orderEvenNotStable(int[] number)
  {
    int nextEven = 0;
    int nextOdd = number.length-1;
    while(nextEven<nextOdd)
    {
      if(number[nextEven]%2==0)
      {
        nextEven++;
      } else {
        int temp = number[nextEven];
        number[nextEven] = number[nextOdd];
        number[nextOdd] = temp;
        nextOdd--;
      }
    }
    return number;
  }

  private int[] orderEvenMine(int[] number)
  {
    int lastEven=0;
    int explorer=0;
    while (explorer<number.length)
    {
      if(number[explorer]%2==0)
      {
        int temp = number[lastEven];
        number[lastEven] = number[explorer];
        number[explorer] = temp;
        lastEven++;
      }
      explorer++;
    }
    return number;
  }
}
