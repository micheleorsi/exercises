package problems;

import org.junit.Assert;
import org.junit.Test;

public class ModularExponentiation
{
  private int modExp(int base,int exp,int mod)
  {
    if(mod<2)
    {
      throw new IllegalArgumentException("");
    }
    if(exp==0)
    {
      return 0;
    }
    if(exp==1)
    {
      return base;
    }
    if(exp%2==0)
    {
      int partialResult = modExp(base,exp/2,mod);
      return (partialResult * partialResult) % mod;
    } else
    {
      return base%mod * modExp(base,exp-1,mod)%mod;
    }
  }

  @Test
  public void test()
  {
    Assert.assertEquals(3,modExp(2,3,5));
    Assert.assertEquals(5,modExp(5,3,10));
    Assert.assertEquals(0,modExp(4,2,4));
  }
}
