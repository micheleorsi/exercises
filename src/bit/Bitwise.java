package bit;

import org.junit.Assert;
import org.junit.Test;

public class Bitwise
{

  @Test
  public void test0()
  {
    Assert.assertEquals(10,Math.abs(-10));
    Assert.assertEquals(13.0,Math.ceil(12.3),0.1);
    Assert.assertEquals(12.0,Math.floor(12.3),0.1);
    Assert.assertEquals(-12.0,Math.ceil(-12.3),0.1);
    Assert.assertEquals(-13.0,Math.floor(-12.3),0.1);
    Assert.assertEquals(10,Math.min(10,20));
    Assert.assertEquals(20,Math.max(10,20));
    Assert.assertEquals(16,Math.pow(2,4),0.1);
    Assert.assertEquals(125,Math.pow(5,3),0.1);
  }

  @Test
  public void test() {
    int maxValue = Integer.MAX_VALUE;
    int minValue = Integer.MIN_VALUE;
    int a = 60;	/* 60 = 0011 1100 */
    int b = 13;	/* 13 = 0000 1101 */
    int c = 0;

    c = a & b;        /* 12 = 0000 1100 */
    System.out.println("a & b = " + c );

    c = a | b;        /* 61 = 0011 1101 */
    System.out.println("a | b = " + c );

    c = a ^ b;        /* 49 = 0011 0001 */
    System.out.println("a ^ b = " + c );

    c = ~a;           /*-61 = 1100 0011 */
    System.out.println("~a = " + c );

    c = a << 2;       /* 240 = 1111 0000 */
    System.out.println("a << 2 = " + c );

    c = a >> 2;       /* 15 = 1111 */
    System.out.println("a >> 2  = " + c );

    c = a >>> 2;      /* 15 = 0000 1111 */
    System.out.println("a >>> 2 = " + c );


    int bitmask = 0x000F; // 0000 0000 0000 1111
    int val = 0x2222; // 0010 0010 0010 0010
    // prints "2"
    System.out.println("bitmask: "+ bitmask);
    System.out.println("bitmask: "+ bitmask);
    System.out.println("val: "+val );
    System.out.println(val & bitmask);

  }
}
