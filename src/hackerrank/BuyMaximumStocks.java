package hackerrank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class BuyMaximumStocks {

    @Test
    public void test() {
        Assert.assertEquals(4, dynamMem3(45l, new int[]{10, 7, 19}, 3));
        Assert.assertEquals(5, dynamMem3(10l, new int[]{2, 1, 3}, 3));
        Assert.assertEquals(5, dynamMem3(10l, new int[]{2, 3, 1}, 3));
    }

    final int ARRAY_SIZE = 100000;
    int[] arr = new int[ARRAY_SIZE];

    @Before
    public void setup() {
        for(int i=0; i<ARRAY_SIZE;i++) {
            arr[i]=100%(i+1)+1;
        }
    }


    @Test
    public void testTimeout3() {
        Assert.assertEquals(5000050000l, dynamMem3(1000000000000l, arr, ARRAY_SIZE));
    }

    @Test
    public void testMax() {
        Assert.assertEquals(80l,maxOf(new long[]{4l,6l,10l,-10l,80}));
    }

    // time: O(n*n)
    long dynamMem2(long k, int[] a, int n) {
        int stock=0;
        boolean[] used = new boolean[n];
        int remaining=n;

        while(k>0 && remaining>0) {

            int min = Integer.MAX_VALUE;
            int minIdx = 0;


            for (int i = 0; i < n; i++) {
                if (used[i]==false && a[i] < min) {
                    min = a[i];
                    minIdx = i;
                }
            }

            long quot = k/(long)min;
            long times = Math.min(quot,minIdx+1);

            k-=(times*min);
            stock+=times;
            used[minIdx]=true;
            remaining--;
        }
        return stock;
    }

    class Price implements Comparable<Price> {
        Integer price;
        Integer maxVal;

        public Price(int price, int maxVal) {
            this.price = price;
            this.maxVal = maxVal;
        }

        @Override
        public int compareTo(Price o) {
            return this.price.compareTo(o.price);
        }
    }

    // time: O(n* log n)
    long dynamMem3(long k, int[] a, int n) {
        long stock=0;
        PriorityQueue<Price> list = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            list.add(new Price(a[i],i+1));
        }


        while(k>0 && list.size()>0) {
            Price toUse=list.element();

            long quot = k/(long)toUse.price;
            long times = Math.min(quot,toUse.maxVal);

            k-=(times*toUse.price);
            stock+=times;

            list.remove(toUse);
        }
        return stock;

    }

    // budget * a.length
    long dynamMem(long budget, int[] a) {

        int[] count = new int[a.length];
        long totStock = 0;

        int temp=0;
        for(int b=1; b<=budget; b++) {
            int stock = 0;
            temp++;
            for(int j=0; j<a.length; j++) {
                if(temp-a[j]>=0 && count[j]<j+1) {
                    temp-=a[j];
                    stock++;
                    count[j]++;
                }
                if(temp==0) {
                    break;
                }
            }
            totStock+=stock;
        }

        return totStock;
    }

    private int maxMem() {
        return 0;
    }

    // time n!
    long dynam(long k, int[] a, int idx) {
        if(k==0 || idx>a.length-1) {
            return 0;
        }
        long affordableStock = k/(long)a[idx];
        long possibleStoc = Math.min(idx+1,affordableStock);
        long[] numberOfStock = new long[(int)(possibleStoc+1)];
        for(int i=0; i<=possibleStoc; i++) {
            numberOfStock[i] = dynam(k - (i*a[idx]),a,idx+1)+i;
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
