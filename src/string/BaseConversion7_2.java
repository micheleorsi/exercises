package string;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class BaseConversion7_2
{

  char[] numAsChar = {
    '0','1','2','3','4','5','6','7','8','9',
    'A','B','C','D','E','F'
  };

  String inputConversion(String s1, int b1, int b2)
  {
    BigInteger numberAsInt = new BigInteger("0");
    // convert to number
    int power = 0;
    for(int i=s1.length()-1; i>=0; i--)
    {
      if(s1.charAt(i)=='-')
      {
        BigInteger negate = numberAsInt.negate();
        break;
      }
      char charAt = s1.charAt(i);
      numberAsInt = new BigInteger(b1+"").pow(power)
            .multiply(new BigInteger(charAt+""))
            .add(numberAsInt);
      power++;
    }

    // convert to the new base
    StringBuffer sb = new StringBuffer();
    while(Math.abs(numberAsInt.intValue())>0)
    {
      int digit = Math.abs(numberAsInt.intValue()%b2);
      sb.append(numAsChar[digit]);
      numberAsInt = numberAsInt.divide(new BigInteger(b2+""));
    }
    if(s1.length()>0 && s1.charAt(0)=='-')
    {
      return sb.append('-').reverse().toString();
    } else
    {
      return sb.reverse().toString();
    }
  }

  @Test
  public void test()
  {
    Assert.assertEquals("",inputConversion("",10,2));
    Assert.assertEquals("11",inputConversion("3",10,2));
    Assert.assertEquals("1000001",inputConversion("65",10,2));
    Assert.assertEquals("132",inputConversion("72",10,7));
    Assert.assertEquals("72",inputConversion("132",7,10));
    Assert.assertEquals("F",inputConversion("15",10,16));
    Assert.assertEquals("65",inputConversion("1000001",2,10));


  }
}
