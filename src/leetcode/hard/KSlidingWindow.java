package leetcode.hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KSlidingWindow {


    @Test
    public void test() {
        int[] ints = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        List<Integer> descList = new ArrayList<Integer>();
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < k - 1; i++) addDescList(descList, nums[i]);
        for (int i = 0; i < res.length; i++) {
            addDescList(descList, nums[i + k - 1]);
            res[i] = descList.get(0);
            if (nums[i] == descList.get(0)) descList.remove(0); //to delete the left most.
        }
        return res;
    }

    public void addDescList(List<Integer> descList, int num) {
        while (!descList.isEmpty() && num > descList.get(descList.size() - 1)) descList.remove(descList.size() - 1);
        descList.add(num);
    }

}
