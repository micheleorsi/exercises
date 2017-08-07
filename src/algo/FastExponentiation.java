package algo;

import org.junit.Assert;
import org.junit.Test;

/**
 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 = 2^8
 * 2 * 2 * 2 * 2 = 2^4
 * 2 * 2 = 2^2
 * 2 = 2
 */
public class FastExponentiation
{
  @Test
  public void test()
  {
    Assert.assertEquals(0,power(0,9));
    Assert.assertEquals(Integer.MIN_VALUE,power(0,0));
    Assert.assertEquals(1,power(2,0));
    Assert.assertEquals(2,power(2,1));
    Assert.assertEquals(4,power(2,2));
    Assert.assertEquals(8,power(2,3));
    Assert.assertEquals(16,power(2,4));
    Assert.assertEquals(32,power(2,5));
    Assert.assertEquals(64,power(2,6));
    Assert.assertEquals(125,power(5,3));
  }
  int power(int base, int exp)
  {
    if(base==exp && base == 0)
    {
      return Integer.MIN_VALUE;
    }
    if (exp==0)
    {
      return 1;
    }
    if(exp==1)
    {
      return base;
    }
    int result = power(base, exp/2);
    int returnResult = result*result;
    if(exp%2==0)
    {
      return returnResult;
    }
    else{
      return returnResult*base;
    }
  }
}
