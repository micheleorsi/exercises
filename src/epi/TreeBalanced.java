package epi;

import org.junit.Assert;
import org.junit.Test;

public class TreeBalanced {
    boolean isBalanced(Node root) {
        int balanced = isBalanced(root, 0);
        return balanced>-1;
    }

    int isBalanced(Node root, int level) {
        if(root==null) {
            return level;
        }
        int l = isBalanced(root.left,level+1);
        int r = isBalanced(root.right,level+1);
        if(l<0 || r<0) {
            return -1;
        }
        int diff = Math.abs(l-r);
        if(diff>1) {
            return -1;
        } else {
            return Math.max(l,r);
        }
    }

    @Test
    public void nullTest() {
        Assert.assertTrue(isBalanced(null));
    }

    @Test
    public void notBalanced() {
        Node eight = new Node(8);
        Node four = new Node(4);
        Node thirteen = new Node(13);
        Node eleven = new Node(11);
        Node fifteen = new Node(15);
        Node fourteen = new Node(14);

        eight.left = four;
        eight.right = thirteen;
        thirteen.left=eleven;
        thirteen.right=fifteen;
        fifteen.left=fourteen;

        Assert.assertFalse(isBalanced(eight));
    }

    @Test
    public void balanced() {
        Node eight = new Node(8);
        Node four = new Node(4);
        Node thirteen = new Node(13);
        Node eleven = new Node(11);
        Node fifteen = new Node(15);
//        Node fourteen = new Node(14);

        eight.left = four;
        eight.right = thirteen;
        thirteen.left=eleven;
        thirteen.right=fifteen;
//        fifteen.left=fourteen;

        Assert.assertTrue(isBalanced(eight));
    }
}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}
