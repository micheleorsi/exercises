package bit;

import org.junit.Assert;
import org.junit.Test;

public class SwapBits
{

  long swapbit(long number, int i, int j)
  {
    long bitMask = (1l << i) | (1l << j);

    number = number ^ bitMask;

    return number;
  }

  @Test
  public void test()
  {
    Assert.assertEquals(6,swapbit(10l,2,3)); // 1010 -> 0110

  }
}
