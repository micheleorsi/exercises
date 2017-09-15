package epi.chap6;

import org.junit.Assert;
import org.junit.Test;

public class Ex6_6_BuyAndSellStockOnce {

    @Test
    public void test() {
        Assert.assertEquals(30,maxProfit(new int[]{310,315,275,295,260,270,290,230,255,250}));
    }

    int maxProfit(int[] array) {
        // check if array.length <0
        int min=array[0];
        int maxProfit=Integer.MIN_VALUE;
        for(int i=1; i<array.length; i++) {
            maxProfit = Math.max(array[i]-min,maxProfit);
            min = Math.min(array[i],min);
        }
        return maxProfit;
    }
}
