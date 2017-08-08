package problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * F(n) =
 * * F(n-1)+F(n-2) if n>1
 * * n if n = 0,1
 */
public class Fibonacci
{
  
  @Test
  public void test()
  {
    Assert.assertEquals(0,fibonacci(0));
    Assert.assertEquals(1,fibonacci(1));
    Assert.assertEquals(1,fibonacci(2));
    Assert.assertEquals(2,fibonacci(3));
    Assert.assertEquals(3,fibonacci(4));
    Assert.assertEquals(5,fibonacci(5));
    Assert.assertEquals(8,fibonacci(6));
    Assert.assertEquals(13,fibonacci(7));
    Assert.assertEquals(21,fibonacci(8));
    Assert.assertEquals(34,fibonacci(9));

  }

  @Test
  public void performanceTestWitRecursive()
  {
    Assert.assertEquals(433494437,fibonacciRecursive(43));
  }

  @Test
  public void performanceTestWitRecursiveWithMem()
  {
    Assert.assertEquals(433494437,fibonacciRecursiveMemoization(43,new int[44]));
  }

  private int fibonacci(int i)
  {
    int iterative = fibonacciIterative(i);
    int recursive = fibonacciRecursive(i);
    int recursiveWithMem = fibonacciRecursiveMemoization(i,new int[i+1]);
    int recursiveTail = fibonacciRecursiveTail(i,1,0);
    if(iterative!=recursive || recursive!=recursiveWithMem || recursive!=recursiveTail)
    {
      throw new RuntimeException("diff "+iterative+" "+recursive+" "+recursiveWithMem+" "+recursiveTail);
    }
    return iterative;
  }

  private int fibonacciRecursive(int i)
  {
    if(i <= 1) {
      return i;
    }
    return fibonacciRecursive(i-1) + fibonacciRecursive(i-2);

  }

  private int fibonacciRecursiveTail(int i,int acc1,int acc2)
  {
    if(i==0)
    {
      return 0;
    }
    if(i==1)
    {
      return acc1;
    }

    return fibonacciRecursiveTail(i-1,acc1+acc2,acc1);

  }





















  private int fibonacciRecursiveMemoization(int i, int[] cache)
  {
    if(i<=1) {
      return i;
    }
    if(cache[i]>0) {
      return cache[i];
    }
    int tot=fibonacciRecursiveMemoization(i-1,cache)+fibonacciRecursiveMemoization(i-2,cache);
    cache[i]=tot;
    return tot;
  }

  private int fibonacciIterative(int number)
  {
    int accMinus2 = 0;
    int accMinus1 = 1;
    for(int i=1; i<number; i++)
    {
      int actual = accMinus1+accMinus2;
      accMinus2 = accMinus1;
      accMinus1 = actual;
    }
    if(number==0) {
      return 0;
    }
    return accMinus1;
  }
}
