package hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegex
{

  /**
   *
   * form "A.B.C.D"
   * A, B, C, and D may range from 0 to 255
   * Leading zeros are allowed
   * The length of A, B, C, or D can't be greater than 3
   *
   * @param ipAddress
   */
  public boolean isValid(String ipAddress)
  {
    Pattern p = Pattern.compile(
      "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$"
    );
    Matcher m = p.matcher(ipAddress);
    return m.matches();

  }

  @Test
  public void testhack()
  {
    String[] invalid = new String[]{
            "000.12.234" +
                    "121.234.12.12" +
                    "23.45.12.56"+
                    "000.12.12.034" +
                    "121.234.12.12" +
                    "23.45.12.56"
    };

    for(String str: invalid) {
      Assert.assertEquals(false,isValid(str));
    }


  }

  @Test
  public void valid()
  {
    String[] list = new String[]{
      "000.12.12.034" +
        "121.234.12.12" +
        "23.45.12.56"+
      "000.12.12.034" +
        "121.234.12.12" +
        "23.45.12.56"
    };

    for(String str: list) {
      Assert.assertEquals(str,true,isValid(str));
    }
  }

  @Test
  public void notvalid()
  {
    String[] list = new String[]{
      "000.12.234.23.23" +
        "666.666.23.23" +
        ".213.123.23.32" +
        "23.45.22.32." +
        "I.Am.not.an.ip"+
      "122.23" +
        "Hello.IP"+
        "again not ip" +
        ""+
        "00.12.123.123123.123"
    };

    for(String str: list) {
      Assert.assertEquals(false,isValid(str));
    }

  }
}
