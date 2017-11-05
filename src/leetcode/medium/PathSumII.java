package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    @Test
    public void test() {
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode eleven = new TreeNode(11);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);

        TreeNode eight = new TreeNode(8);
        TreeNode thirteen = new TreeNode(13);
        TreeNode fourr = new TreeNode(4);
        TreeNode fiver = new TreeNode(5);
        TreeNode one = new TreeNode(1);

        five.left=four;
        four.left=eleven;
        eleven.left=seven;
        eleven.right=two;

        five.right=eight;
        eight.left=thirteen;
        eight.right=fourr;
        fourr.left=fiver;
        fourr.right=one;

        List<List<Integer>> integers = pathSum(five,22);
        Assert.assertEquals(integers.get(0), Arrays.asList(5,4,11,2));
        Assert.assertEquals(integers.get(1), Arrays.asList(5,8,4,5));

        Assert.assertEquals(pathSum(null,22), Arrays.asList());

    }

    @Test
    public void testNegative() {
        TreeNode two = new TreeNode(-2);
        TreeNode three = new TreeNode(-3);
        TreeNode hundr = new TreeNode(100);

        two.right=three;
        two.left=hundr;

        List<List<Integer>> lists = pathSum(two, -5);
        Assert.assertEquals(lists.get(0), Arrays.asList(-2,-3));


    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<>();
        if(root!=null) {
            recursion(sum, 0, root, list, new LinkedList<Integer>());
        }
        return list;
    }

    void recursion(int sumExpected,int actualSum, TreeNode actual, List<List<Integer>> list,List<Integer> temp) {
        actualSum = actualSum + actual.val;

//        if(actualSum!=sumExpected) {
            temp.add(actual.val);

            if(actualSum==sumExpected && actual.left==null && actual.right==null) {
                list.add(new ArrayList<>(temp));
            }
            if(actual.left!=null) {
                recursion(sumExpected, actualSum, actual.left, list, temp);
            }
            if(actual.right!=null) {
                recursion(sumExpected, actualSum, actual.right, list, temp);
            }
            temp.remove(temp.size()-1);

//        }

    }
}
