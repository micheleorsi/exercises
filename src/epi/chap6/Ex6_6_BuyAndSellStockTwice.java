package epi.chap6;

import org.junit.Assert;
import org.junit.Test;

public class Ex6_6_BuyAndSellStockTwice {

    @Test
    public void test() {
        Assert.assertEquals(10,maxProfit(new int[]{12,11,13,9,12,8,14,13,15}));
    }

    int maxProfit(int[] array) {
        int[] maxLeft=new int[array.length];
        int[] maxRight=new int[array.length];

        int minLeft=array[0];
        int maxR=array[array.length-1];
        maxLeft[0]=0;
        maxRight[array.length-1]=0;

        for(int i=array.length-2; i>=0; i--){
            maxRight[i]=Math.max(maxRight[i+1],maxR-array[i]);
            maxR =Math.max(maxR,array[i]);
        }

        int max = 0;
        for(int i=1; i<array.length; i++) {
            maxLeft[i]=Math.max(maxLeft[i-1], array[i]-minLeft);
            minLeft=Math.min(minLeft,array[i]);
            max = Math.max(max, maxRight[i]+maxLeft[i]);
        }

        return max;


    }




}
