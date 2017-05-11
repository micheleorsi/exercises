package string;

import org.junit.Assert;
import org.junit.Test;

public class Palindromic7_0
{

  @Test
  public void test()
  {
    Assert.assertFalse(isPalindromic("1234567890"));
    Assert.assertTrue(isPalindromic("123454321"));
  }

  private boolean isPalindromic(String test)
  {
    int leftCounter = 0;
    int rightCounter = test.length()-1;

    while(leftCounter<=rightCounter)
    {
      if(test.charAt(leftCounter)!=test.charAt(rightCounter))
      {
        return false;
      }
      leftCounter++;
      rightCounter--;
    }
    return true;
  }
}
