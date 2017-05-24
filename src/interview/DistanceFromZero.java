package interview;

import org.junit.Assert;
import org.junit.Test;

/**
 * A non-negative integer variable V is given. There are two actions available that modify its value:
 * - if V is odd, subtract 1 from it
 * - if V is even, divide it by 2
 *
 * These actions are performed until the value of V becomes 0.
 *
 * For example, if V initially contains value 28, it will become 0 after seven steps:
 * - V contains value 28, which is even: divide by 2 and obtain 14
 * - V contains value 14, which is even: divide by 2 and obtain 7
 * - V contains value 7, which is odd: subtract 1 and obtain 6
 * - V contains value 6, which is even: divide by 2 and obtain 3
 * - V contains value 3, which is odd: subtract 1 and obtain 2
 * - V contains value 2, which is even: divide by 2 and obtain 1
 * - V contains value 1, which is odd: subtract 1 and obtain 0
 *
 * Write a function:
 *  class Solution { public int solution(String s); }
 * that, given a zero-indexed string S consisting of N characters containing a binary representation of the initial value of variable V, returns the number of stpes after which the value of V will become 0, as described above.
 *
 * Assume that:
 * - N is an integer within the range [1 .. 1,000,000]
 * - string S consists only of the characters "0" and/or "1"
 * - the binary representation is big-endian, i.e. the first character of string S corresponds to the most significant bit;
 * - the binary representation may contain leading zeros
 *
 * For example, given string S = "011100" the function should return 7, becaus string S represents the number 28 and 28 becomes 0 after seven steps, as explained above.
 *
 * Complexity:
 * - expected worst-case time complexity is O(N)
 * - expected worst-case space complexity is O(1) (not counting the storage required for input arguments)
 *
 */
public class DistanceFromZero
{

  @Test
  public void test()
  {
    Assert.assertEquals(7,solution("011100"));
    Assert.assertEquals(2,solution("10"));
  }

  public int solution(String s)
  {
    char[] stringChar = s.toCharArray();
    // leading zero
    int counter = 0;
    while(stringChar[counter]=='0') {
    counter++;
  }
    // now counter has the value of the index with first ‘1’

    //
    int steps = 0;
    for(int i=stringChar.length-1; i>=counter; i--)
    {
      if(stringChar[i] =='1')
      {
        steps+=2;
      }
		else
      {
        steps++;
      }
    }
    return steps-1;
  }
}
