package algo.binarysearchtree;

import org.junit.Assert;
import org.junit.Test;

public class DeletingFromATree {
    /**
     *            8
     *        /       \
     *       4         12
     *    /    \     /    \
     *   2     6    10    14
     *  / \   / \  / \   /   \
     * 1  3  5  7 9  11 13  15
     */
    @Test
    public void test() {
        BSTNode root = BSTBuilder.getRoot();
        delete(7, root);
        Assert.assertNull(root.left.right.right);
        delete(6, root);
        Assert.assertEquals(5,root.left.right.value);
        delete(10, root);
        Assert.assertEquals(11,root.right.left.value);
        Assert.assertEquals(9,root.right.left.left.value);
    }

    private BSTNode delete(int num, BSTNode actual) {
        /* Base Case: If the tree is empty */
        if (actual == null) return actual;

        /* Otherwise, recur down the tree */
        if (num < actual.value)
            actual.left = delete(num, actual.left);
        else if (num > actual.value)
            actual.right = delete(num, actual.right);

            // if num is same as actual's num, then This is the node
            // to be deleted
        else {
            // node with only one child or no child
            if (actual.left == null)
                return actual.right;
            else if (actual.right == null)
                return actual.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            actual.value = minValue(actual.right);

            // Delete the inorder successor
            actual.right = delete(actual.value, actual.right);
        }

        return actual;
    }

    int minValue(BSTNode actual)
    {
        int minv = actual.value;
        while (actual.left != null)
        {
            minv = actual.left.value;
            actual = actual.left;
        }
        return minv;
    }
}
