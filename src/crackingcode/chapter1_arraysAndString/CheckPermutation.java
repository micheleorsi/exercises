package crackingcode.chapter1_arraysAndString;

import org.junit.Assert;
import org.junit.Test;

public class CheckPermutation
{

  boolean isPermutation(String s1, String s2)
  {
    if(s1.length()!=s2.length())
    {
      return false;
    }
    int[] charRepo = new int[128];
    for(int i=0; i<s1.length(); i++)
    {
      char singleChar = s1.charAt(i);
      charRepo[singleChar]++;
    }

    for(int i=0; i<s2.length(); i++)
    {
      char singleChar = s2.charAt(i);
      if(charRepo[singleChar]==0)
      {
        return false;
      }
      else {
        charRepo[singleChar]--;
      }
    }
    return true;
  }

  @Test
  public void test()
  {
    Assert.assertTrue(isPermutation("abcd","abdc"));
    Assert.assertFalse(isPermutation("abcdqwe","abdc"));
    Assert.assertTrue(isPermutation("",""));
  }
}
