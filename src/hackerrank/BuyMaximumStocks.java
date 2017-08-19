package hackerrank;

import org.junit.Assert;
import org.junit.Test;

public class BuyMaximumStocks {

    @Test
    public void test() {

        Assert.assertEquals(4, dynam((long) 45, new int[]{10, 7, 19}, 0, 0));
        Assert.assertEquals(5, dynam((long) 10, new int[]{2, 1, 3}, 0, 0));

    }

    @Test(timeout = 10*1000l)
    public void testTimeout() {
        final int ARRAY_SIZE = 15;
        int[] arr = new int[ARRAY_SIZE];
        for(int i=0; i<ARRAY_SIZE;i++) {
            arr[i]=100;
        }
        Assert.assertEquals(55, dynam(10000l, arr, 0, 0));
    }

    @Test
    public void testMax() {
        Assert.assertEquals(80l,maxOf(new long[]{4l,6l,10l,-10l,80}));
    }

    // REMEMBER int k instead of long k!!!!!
//    long dynamMem(int k, int[] a, int idx, int stock) {
//        int[][] K = new int[a.length+1][k];
//        return K[a.length][k];
//
//        for(int i=0;)
//
//    }

    long dynam(long k, int[] a, int idx, int stock) {
        if(k==0 || idx>a.length-1) {
            return stock;
        }
        long affordableStock = k/(long)a[idx];
        long possibleStoc = Math.min(idx+1,affordableStock);
        long[] numberOfStock = new long[(int)(possibleStoc+1)];
        for(int i=0; i<=possibleStoc; i++) {
            numberOfStock[i] = dynam(k - (i*a[idx]),a,idx+1,stock+i);
        }
        long max = maxOf(numberOfStock);
        return max;
    }

    long maxOf(long[] array) {
        long max=0l;
        for(int i=0; i<array.length; i++) {
            if(array[i]>max) {
                max=array[i];
            }
        }
        return max;
    }

}
