package crackingcode.chapter8_recursionanddynamic;

import org.junit.Assert;
import org.junit.Test;

public class Question {
    public static int makeChange(int amount, int[] denoms, int index) {
        if (index >= denoms.length) {
            if(amount==0) {
                return 1; // one denom remaining -> one way to do it
            } else {
                return 0;
            }
        }
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange(amountRemaining, denoms, index + 1); // go to next denom
        }
        return ways;
    }

    public static int makeChange(int amount, int[] denoms) {
        return makeChange(amount, denoms, 0);
    }

    public static void main(String[] args) {
        int[] denoms = {25, 10, 5, 1};
        int ways = makeChange(300322, denoms);
        System.out.println(ways);
    }

    @Test
    public void test() {
        Assert.assertEquals(1,makeChange(1, new int[]{25, 10, 5, 1}));
        Assert.assertEquals(1,makeChange(2, new int[]{25, 10, 5, 1}));
        Assert.assertEquals(1,makeChange(3, new int[]{25, 10, 5, 1}));
        Assert.assertEquals(1,makeChange(4, new int[]{25, 10, 5, 1}));
        Assert.assertEquals(2,makeChange(5, new int[]{25, 10, 5, 1}));
        Assert.assertEquals(2,makeChange(6, new int[]{25, 10, 5, 1}));
        Assert.assertEquals(2,makeChange(7, new int[]{25, 10, 5, 1}));
        Assert.assertEquals(2,makeChange(8, new int[]{25, 10, 5, 1}));
        Assert.assertEquals(2,makeChange(9, new int[]{25, 10, 5, 1}));
        Assert.assertEquals(4,makeChange(10, new int[]{25, 10, 5, 1}));


        Assert.assertEquals(1,makeChange(5, new int[]{5, 2}));
        Assert.assertEquals(1,makeChange(5, new int[]{25, 10, 5, 2}));

    }


}