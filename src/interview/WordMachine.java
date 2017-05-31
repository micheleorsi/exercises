package interview;

import org.junit.Assert;
import org.junit.Test;

/**
 * It is a system that performs a sequence of simple operations on a stack of integers.
 * Initially the stack is empty. The sequence of operations is given as a string.
 * Operations are separated by single spaces. The following operations may be specificed:
 *
 * - an integer X (between 0 and 2^20-1): the machine pushes X onto the stack;
 * - "POP": the machine removes the topmost number from the stack;
 * - "DUP": the machine pushes a duplicate of the topmost number onto the stack;
 * - "+": the machine pops the two topmost elements from the stack; adds them together and pushes the sum onto the stack;
 * - "-": the machine pops the two topomost elements form the stack, substracts the second one from the first (topmost) one and pushes the difference onto the stack.
 *
 * After processing all the operations, the machine returns the topmost value from the stack.
 * The machine processes 20-bit unsigned integers (numbers between 0 and 2^20-1). An overflow in addition or underflow in substraction causes an error. The machine also reports an error when it tries to perform an operation that expects more numbers ot the stack than the stack actually contains.
 * Also, if, after performing all the operations, the stack is empty, the machine reports an error.
 *
 * For example, given a string "13 DUP 4 POP 5 DUP + DUP + -", the machine performs the following operations
 *
 * OPERATION          COMMENT             STACK
 *                                        [empty]
 * "13"               push 13             13
 * "DUP"              duplicate 13        13, 13
 * "4"                push 4              13, 13, 4
 * "POP"              pop 4               13, 13
 * "5"                push 5              13, 13, 5
 * "DUP"              duplicate 5         13, 13, 5, 5
 * "+"                add 5 and 5         13, 13, 10
 * "DUP"              duplicate 10        13, 13, 10, 10
 * "+"                add 10 and 10       13, 13, 20
 * "-"                subtract 13 from 20 13, 7
 *
 * Finally the machine will return 7
 *
 * Given a string "5 6 + -", the machine reports an error, since, after the addition, there is only one number on the stack, but the subtraction operation expects two.
 * Given a string "3 DUP 5 - -", the machine reports an error, since the second subtraction yields a negative result.
 *
 * Write a function:
 *  class Solution {public int solution(String s);}
 * that, given a String S containing a sequence of operations for the word machine, returns the result the machine would return after processing the operations.
 * The function should return -1 if the machine would report an error while processing the operations.
 *
 * For example, given string S = "13 DUP 4 POP 5 DUP + DUP + -" the function should return 7, as explained in the example above. Given string S = "5 6 + - " or S="3 DUP 5 - -" the function should return -1.
 *
 * Assume that:
 * - the length of S is within the range [0 .. 2000]
 * - S is a valid sequence of word machine operations.
 *
 * In your solution, focus in correctness. The performance of your solution will not be the focus of the assessment
 */
public class WordMachine
{

  @Test
  public void test()
  {
    Assert.assertEquals(true,true);
  }
}
