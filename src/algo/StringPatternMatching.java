package algo;

import org.junit.Assert;
import org.junit.Test;

public class StringPatternMatching
{
  @Test
  public void testPattern()
  {
    Assert.assertEquals(9,
      findPattern("ciao","012345678ciao012345sadfadsfadsfdsf"));
    Assert.assertEquals(9,
      findPattern("ciao","cia345678ciao012345sadfadsfadsfdsf"));
    Assert.assertEquals(-1,
      findPattern("ciao","01234567dfadsfadsfdsf"));
  }

  private int findPattern(String pattern, String text)
  {
    int patternIdx = 0;
    for(int i=0; i<text.length(); i++)
    {
      if(text.charAt(i)==pattern.charAt(patternIdx))
      {
        if(patternIdx==pattern.length()-1)
        {
          return i-patternIdx;
        }
        patternIdx++;
      }
      else
      {
        patternIdx = 0;
      }
    }
    return -1;
  }

}
