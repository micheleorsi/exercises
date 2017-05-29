package algo;

import org.junit.Assert;
import org.junit.Test;

/**
 * 2 * 2 * 2 * 2
 */
public class FastExponentiation
{
  @Test
  public void test()
  {
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
    if (exp==0)
    {
      return 1;
    }
    if(exp==1)
    {
      return base;
    }
    if(exp%2==0)
    {
      int result = power(base, exp/2);
      return result * result;
    }
    else{
      return base * power(base, exp-1);
    }
  }
}
