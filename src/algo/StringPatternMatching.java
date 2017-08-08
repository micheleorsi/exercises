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
    Assert.assertEquals(0,
            findPattern("ciao","ciao012345678ciao012345sadfadsfadsfdsf"));
    Assert.assertEquals(9,
            findPattern("ciao","012345678ciao"));
    Assert.assertEquals(9,
      findPattern("ciao","cia345678ciao012345sadfadsfadsfdsf"));
    Assert.assertEquals(-1,
      findPattern("ciao","01234567dfadsfadsfdsf"));
  }

  /**
   * solution 2.5.3
   *
   * @param pattern
   * @param text
   * @return
   */
  private int findPattern(String pattern, String text)
  {

    for(int i = 0; i<= (text.length() - pattern.length()); i++)
    {
      int j=0;
      while(((j< pattern.length()) && (text.charAt(i + j) ==pattern.charAt(j))))
      {
        j++;
      }
      if(j== pattern.length())
        return i;
    }
    return -1;
  }

}
