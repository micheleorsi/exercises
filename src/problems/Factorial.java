package problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * F(n) = n * (n-1) * (n-2) * (n-2)
 *
 */
public class Factorial
{

  @Test
  public void test()
  {
    Assert.assertEquals(1,factorial(1));
    Assert.assertEquals(1,factorial(0));
    Assert.assertEquals(2,factorial(2));
    Assert.assertEquals(6,factorial(3));
    Assert.assertEquals(24,factorial(4));
    Assert.assertEquals(120,factorial(5));
    Assert.assertEquals(720,factorial(6));
  }

  private int factorialRecursiveTail(int number,int acc)
  {
    if(number <=1)
    {
      return acc;
    }
    else {
      return factorialRecursiveTail(number-1,acc*number);
    }
  }

  private int factorialRecursive(int number)
  {
    if(number<=1) {
      return 1;
    } else {
      return number*factorialRecursive(number-1);
    }
  }

  private int factorialIterative(int number)
  {
    int acc = 1;
    for(int i=1; i<=number;i++)
    {
      acc=acc*i;
    }
    return acc;
  }

  private int factorial(int i)
  {
    int recursive = factorialRecursive(i);
    int iterative = factorialIterative(i);
    int recursiveTail = factorialRecursiveTail(i,1);
    if(recursive!=iterative || recursive!= recursiveTail)
    {
      throw new RuntimeException("diff "+recursive+" != "+iterative+" != "+recursiveTail);
    }
    return recursive;
  }
}
