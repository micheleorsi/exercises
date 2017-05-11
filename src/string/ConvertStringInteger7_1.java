package string;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class ConvertStringInteger7_1
{

  int convert(String number)
  {
    int power = 0;

    int total = 0;

    boolean negative = false;
    int index = number.length()-1;
    while (index>=0)
    {
      if(index==0 && number.charAt(index)=='-')
      {
        negative=true;
      } else
      {
        int tempNumber = number.charAt(index) - '0';
        int tenPower = new BigInteger("10").pow(power).intValue();
        total=total+(tenPower*tempNumber);
        power++;
      }
      index--;
    }
    return negative ? total*-1 : total;
  }

  String convert(int number)
  {
    boolean negative = false;
    if(number<0)
    {
      negative = true;
    }
    StringBuffer sb = new StringBuffer();
    while(Math.abs(number)>0)
    {
      char intChar = (char) (Math.abs(number%10)+'0');
      sb.append(intChar);
      number = number/10;
    }
    if(negative)
    {
      sb.append("-");
    }
    if(sb.length()==0)
    {
      return "0";
    }
    return sb.reverse().toString();
  }

  @Test
  public void test()
  {
    Assert.assertEquals(0,convert("0"));
    Assert.assertEquals(-12,convert("-12"));
    Assert.assertEquals(1,convert("1"));
    Assert.assertEquals(314,convert("314"));
    Assert.assertEquals(314314314,convert("314314314"));
    Assert.assertEquals(42,convert("42"));
    Assert.assertEquals(-42,convert("-42"));

    Assert.assertEquals("0",convert(0));
    Assert.assertEquals("-12",convert(-12));
    Assert.assertEquals("1",convert(1));
    Assert.assertEquals("314",convert(314));
    Assert.assertEquals("314314314",convert(314314314));
    Assert.assertEquals("42",convert(42));
    Assert.assertEquals("420",convert(420));
    Assert.assertEquals("-42",convert(-42));


  }
}
