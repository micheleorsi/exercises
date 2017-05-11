package bit;

import org.junit.Assert;
import org.junit.Test;

public class ParityOfAWord
{

  int paritySimple(int number)
  {
    System.out.println(number);

    int result =0;
    while (number>0)
    {
      // simple solution
      System.out.print(" "+number+" & "+(number-1)+" -> ");
      result = result + number & 1;
      result = result % 2;
      number = number >> 1;
      number &= (number-1);
      System.out.println(number);
    }
    return result;

  }
  int parity(int number)
  {
    System.out.println(number);

    int result =0;
    while (number>0)
    {
      result ^= 1;
      System.out.print(" "+number+" & "+(number-1)+" -> ");
      number &= (number-1);
      System.out.println(number);
    }
    return result;
  }

  int parityComplex(int number)
  {
    // with precomputed parity
    return -1;

  }

  @Test
  public void test()
  {
    Assert.assertEquals(1,paritySimple(11)); // 1011
    Assert.assertEquals(0,paritySimple(136)); // 10001000

  }
}
