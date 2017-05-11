package crackingcode.chapter1_arraysAndString;

import org.junit.Assert;
import org.junit.Test;

public class IsUnique
{
  boolean unique(String temp)
  {
    boolean[] letters = new boolean[128];
    for(int i=0;i <temp.length(); i++)
    {
      int letterIndex = temp.charAt(i);
      if(letters[letterIndex]==true)
      {
        return false;
      }
      else
      {
        letters[letterIndex] = true;
      }
    }
    return true;
  }

  boolean unique2(String temp)
  {
    int checker = 0;
    for(int i=0; i<temp.length(); i++)
    {
      int val = temp.charAt(i) - '0';
      if((checker & (1 << val))>0)
      {
        return false;
      }
      checker = checker | (1 << val);
    }
    return true;
  }

  @Test
  public void test()
  {
    Assert.assertTrue(unique("abcdef"));
    Assert.assertTrue(unique(""));
    Assert.assertFalse(unique("abca"));

    Assert.assertTrue(unique2("abcdef"));
    Assert.assertTrue(unique2(""));
    Assert.assertFalse(unique2("abca"));
  }

}
