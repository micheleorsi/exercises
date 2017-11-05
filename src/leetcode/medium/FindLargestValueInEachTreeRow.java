package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindLargestValueInEachTreeRow {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    @Test
    public void test() {
        TreeNode one = new TreeNode(1);
        TreeNode three1 = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode five = new TreeNode(5);
        TreeNode three2 = new TreeNode(3);
        TreeNode nine = new TreeNode(9);

        one.left=three1;
        one.right=two;
        three1.left=five;
        three1.right=three2;
        two.right=nine;

        List<Integer> integers = largestValues(one);
        Assert.assertEquals(1,integers.get(0).intValue());
        Assert.assertEquals(3,integers.get(1).intValue());
        Assert.assertEquals(9,integers.get(2).intValue());

        Assert.assertEquals(Arrays.asList(),largestValues(null));

    }

    List<Integer> largestValues(TreeNode root) {
        // check if root is null
        if(root==null) {
            return new LinkedList<>();
        }
        List<Integer> max = new LinkedList<>();

        recursion(0,max,root);

        return max;
    }

    void recursion(int level, List<Integer> max, TreeNode actual) {
        handleMax(level, max, actual.val);

        // if it is not leaf node
        if(actual.left !=null) {
            recursion(level+1,max,actual.left);
        }
        if(actual.right !=null) {
            recursion(level+1,max,actual.right);
        }
    }

    void handleMax(int level, List<Integer> max, int value) {
        if(max.size()<=level) {
            max.add(value);
        } else if(max.get(level)<value) {
            max.set(level, value);
        }
    }
}
