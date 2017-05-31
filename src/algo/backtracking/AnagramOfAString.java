package algo.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AnagramOfAString
{

  @Test
  public void test()
  {
    anagram(new char[]{'c','i','a','o'}, new ArrayList<>());
  }

  public void anagram(char[] s, List<Character> temp)
  {
    if(temp.size()==s.length)
    {
      System.out.println(temp);
    }
    for (int i=0; i< s.length; i++)
    {
      if(temp.contains(s[i])) continue;
      temp.add(s[i]);
      anagram(s,temp);
      temp.remove(temp.size()-1);
    }
  }
}
