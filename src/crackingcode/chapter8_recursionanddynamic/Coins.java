package crackingcode.chapter8_recursionanddynamic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Coins {

    static final int number = 3;
    static final int expected = 3;
    static final int expectedSubset = 0;

    int recursion=0;

    @Test
    public void testPermutation() {
        List<List<Integer>> list = listPermutation(number);
        Assert.assertEquals(expected,list.size());
        for(List<Integer> l: list) {
            System.out.println(l);
        }
    }

    @Test
    public void testSubset() {
        List<List<Integer>> all = new ArrayList<>();
        int ways = listSubset(number, new int[]{25, 10, 5, 4}, 0, all, new ArrayList<>());
        Assert.assertEquals(expectedSubset,ways);
        Assert.assertEquals(expectedSubset,all.size());
        for(List<Integer> l: all) {
            System.out.println(l);
        }
    }

    private int listSubset(int amount, int[] denoms, int index, List<List<Integer>> all, List<Integer> temp) {
        if(index>=denoms.length-1) {
            all.add(new ArrayList<>(temp));
            return 1;
        }
        int denomAmount = denoms[index];
        int ways =0;
//        if(number==0) {
//
//            return;
//        }
        for (int i = 0; i * denomAmount <= amount; i++) {
            int remaining = amount - i*denomAmount;
            if(i>0) {
                temp.add(denomAmount);
            }
            ways+=listSubset(remaining,denoms,index+1,all,temp);
//            if(i>0) {
//                temp.remove(temp.size()-1);
//            }
        }
        return ways;
    }

    @Test
    public void testCount() {
        recursion=0;
        int count = countPerm(new int[]{25, 10, 5, 1},number);
        Assert.assertEquals(expected,count);
        System.out.println("testCount: "+recursion);

        recursion=0;
        count = countPerm(new int[]{1, 5, 10, 25},number);
        Assert.assertEquals(expected,count);
        System.out.println("testCount: "+recursion);

    }

    int countPerm(int[] array, int n) {
        List<List<Integer>> list = new ArrayList<>();
        return recursionCountPerm(array, n, list);
    }

    private int recursionCountPerm(int[] array, int input, List<List<Integer>> list) {
        recursion++;
        if(input==0) {
            return 1;
        }
        int ways = 0;
        for(int i=0; i<array.length; i++) {
            int newInput = input-array[i];
            if(newInput>=0) {
                ways+= recursionCountPerm(array, newInput, list);
            }
        }
        return ways;
    }

    List<List<Integer>> listPermutation(int n) {
        List<List<Integer>> list = new ArrayList<>();
        recursion(new int[]{25,10,5,1}, n, list, new ArrayList<Integer>());
        return list;
    }

    void recursion(int[] array, int input, List<List<Integer>> list, List<Integer> temp) {
        // list == null
        // temp == null
        //
        if(input==0) {
            list.add(new ArrayList<>(temp));
        }
        for(int i=0; i<array.length; i++) {
            int newInput = input-array[i];
            if(newInput>=0) {
                temp.add(array[i]);
                recursion(array, newInput, list, temp);
                temp.remove(temp.size()-1);
            }
        }
    }



}
