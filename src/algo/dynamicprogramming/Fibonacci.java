package algo.dynamicprogramming;

import org.junit.Test;

public class Fibonacci
{

  @Test
  public void test()
  {
    System.out.println(fibonacci(6));
  }

  public int fibonacci(int n)
  {
    int prev=0;
    int last=1;

    if(n==0) return 0;

    for(int i=2; i<=n; i++)
    {
      int temp = prev+last;
      prev = last;
      last = temp;
    }
    return last;
  }
}
