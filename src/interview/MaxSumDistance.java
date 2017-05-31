package interview;

import org.junit.Assert;
import org.junit.Test;

/**
 * Let A be a non-empty zero-indexed array consisting of N integers. A sum-distance of a pair of indices (P,Q), for 0 <= P <= Q < N, is the value A[P] + A[Q] + (Q - P)
 *
 * For example, for the following array A:
 * - A[0] = 1
 * - A[1] = 3
 * - A[2] = -3
 *
 * there are the following pairs of indices: (0,0), (1,1), (2,2), (0,1), (1,2), (0,2) for each of which the sum-distance is defined as follws:
 * - for (0,0) it is A[0] + A[0] + (0 - 0) = 1 + 1 + 0 = 2
 * - for (1,1) it is A[1] + A[1] + (1 - 1) = 3 + 3 + 0 = 6
 * - for (2,2) it is A[2] + A[2] + (2 - 2) = (-3) + (-3) + 0 = -6
 * - for (0,1) it is A[0] + A[1] + (1 - 0) = 1 + 3 + 1 = 5
 * - for (1,2) it is A[1] + A[2] + (2 - 1) = 3 + (-3) + 1 -1
 * - for (0,2) it is A[0] + A[2] + (2 - 0) = 1 + (-3) + 2 = 0
 *
 * Write a function:
 *  class Solution { public int solution(int[] A); }
 * that, given a zero-indexed array A consisting of N integers, returns the maximal sum-distance value for this array
 *
 * For example, given the following array A:
 * - A[0] = 1
 * - A[1] = 3
 * - A[2] = -3
 * the function should return 6, as explained above.
 *
 * Given the following array A:
 * - A[0] = -8
 * - A[1] = 4
 * - A[2] = 0
 * - A[3] = 5
 * - A[4] = -3
 * - A[5] = 6
 *
 * the function should return 4+6+ (5-1) = 14
 *
 * Assume that:
 * - N is an integer within the range [1 .. 100000]
 * - each element of array A is an integer within the range [-1,000,000,000 .. 1,000,000,000]
 *
 * Complexity:
 * - expected worst case time complexity is O(N)
 * - expected worst case space complexity is O(1), beyond input storage (not counting the storage required for input arguments)
 */
public class MaxSumDistance
{

  @Test
  public void test()
  {
    Assert.assertEquals(true,true);
  }
}
