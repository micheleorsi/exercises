package problems;

import org.junit.Test;

public class StringPermutation
{
  void permutation(String str)
  {
    permutation(str,"");
  }

  void permutation(String str,String prefix)
  {
    if(str.length()==0)
    {
      System.out.println(prefix);
    } else
    {
      for(int i=0; i<str.length(); i++)
      {
        String rem = str.substring(0,i) + str.substring(i+1);
        permutation(rem, prefix+str.charAt(i));
      }
    }
  }

  @Test
  public void test()
  {
    permutation("12345");
  }
}
