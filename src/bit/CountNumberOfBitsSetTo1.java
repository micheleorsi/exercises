package bit;

import org.junit.Assert;
import org.junit.Test;

public class CountNumberOfBitsSetTo1
{

  public short numberofBitAt1(int number)
  {
    System.out.println(number);
    short numberOfBits = 0;
    while(number>0)
    {
      System.out.print(" "+number+" -> ");
      numberOfBits += number & 1;
      number = number >> 1;
      System.out.println(number);
    }
    return numberOfBits;
  }

  @Test
  public void test()
  {
    Assert.assertEquals(1,numberofBitAt1(1)); // 1: 1
//    Assert.assertEquals(2,numberofBitAt1(-1)); // 1: 1
    Assert.assertEquals(1,numberofBitAt1(2)); // 2: 10
    Assert.assertEquals(2,numberofBitAt1(3)); // 3: 11
    Assert.assertEquals(2,numberofBitAt1(5)); // 5: 101
    Assert.assertEquals(3,numberofBitAt1(7)); // 5: 111
    Assert.assertEquals(1,numberofBitAt1(64)); // 64: 1000000
    Assert.assertEquals(2,numberofBitAt1(65)); // 64: 1000001
  }
}
