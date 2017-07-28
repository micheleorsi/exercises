package algo.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AnagramOfAString
{

  @Test
  public void test()
  {
    List<List<Character>> catalog = new ArrayList<>();
    anagram(new char[]{'c','i','a','o'}, catalog, new ArrayList<>());
    for(int i=0; i<catalog.size(); i++)
    {
      System.out.println(catalog.get(i));
    }
  }

  public void anagram(char[] s, List<List<Character>> catalog, List<Character> temp)
  {
    if(temp.size()==s.length)
    {
      catalog.add(new ArrayList<>(temp));
    }
    for (int i=0; i< s.length; i++)
    {
      if(temp.contains(s[i])) continue;
      temp.add(s[i]);
      anagram(s,catalog,temp);
      temp.remove(temp.size()-1);
    }
  }
}
