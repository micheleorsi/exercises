package problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class XpowerToN
{

  @Test
  public void test()
  {
    Assert.assertEquals(2,power(2,1));
    Assert.assertEquals(0,power(0,1));
    Assert.assertEquals(0,power(0,10));
    Assert.assertEquals(1,power(1,3));
    Assert.assertEquals(1,power(1,89));
    Assert.assertEquals(8,power(2,3));
    Assert.assertEquals(25,power(5,2));
    Assert.assertEquals(27,power(3,3));
  }

  private int power(int base, int exp)
  {
    int iterative = powerIterative(base,exp);
    int recursive1 = powerRecursive1(base,exp);
    int recursive0 = powerRecursive0(base,exp);
    if(iterative!=recursive0 || recursive0!=recursive1)
    {
      throw new RuntimeException("diff "+iterative+" "+recursive0+" "+recursive1);
    }
    return iterative;
  }

  private int powerIterative(int base, int exp)
  {
    int result = 1;
    for(int i=0; i<exp; i++)
    {
      result = result * base;
    }
    return result;
  }

  private int powerRecursive0(int base,int exp)
  {
    if(exp==0)
    {
      return 1;
    }
    if(exp==1)
    {
      return base;
    }
    return base * powerRecursive0(base,exp-1);
  }

  private int powerRecursive1(int base,int exp)
  {
    if(exp==0)
    {
      return 1;
    }
    if(exp==1)
    {
      return base;
    }
    if(exp%2 == 0)
    {
      int result = powerRecursive1(base,exp/2);
      return result*result;
    } else
    {
      return base*powerRecursive1(base, exp -1);
    }
  }
}
