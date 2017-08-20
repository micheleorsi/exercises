package crackingcode.chapter4_TreesAndGraphs;

import org.junit.Assert;
import org.junit.Test;

public class BalancedTree {

    @Test
    public void test() {

        Assert.assertTrue(isBalanced(balancedBTree()));
        Assert.assertFalse(isBalanced(nonBalancedBTree()));
    }

    private BNode balancedBTree() {
        BNode node1 = new BNode(1);
        BNode node2 = new BNode(2);
        BNode node3 = new BNode(3);
        BNode node4 = new BNode(4);
        BNode node5 = new BNode(5);
        BNode node6 = new BNode(6);
        BNode node7 = new BNode(7);
        BNode node8 = new BNode(8);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node4.left=node8;

        node3.left=node6;
        node3.right=node7;

        return node1;
    }

    private BNode nonBalancedBTree() {
        BNode node1 = new BNode(1);
        BNode node2 = new BNode(2);
        BNode node3 = new BNode(3);
        BNode node4 = new BNode(4);
        BNode node5 = new BNode(5);
        BNode node8 = new BNode(8);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node4.left=node8;

        return node1;
    }

    boolean isBalanced(BNode node) {
        return check(node,0)!=Integer.MIN_VALUE;
    }

    int check(BNode node, int level) {
        if(node==null) {
            return level;
        }
        int leftH = check(node.left,level+1);
        if(leftH==Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int rightH = check(node.right,level+1);
        if(rightH ==Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int diff = Math.abs(leftH-rightH);
        if(diff>1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftH,rightH);
    }}
