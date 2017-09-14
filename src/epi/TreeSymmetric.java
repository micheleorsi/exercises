package epi;

import org.junit.Assert;
import org.junit.Test;

public class TreeSymmetric {

    @Test
    public void isNotSymmetricNull() {
        Node eight = new Node(8);
        Node four = new Node(4);

        eight.left = four;

        Assert.assertFalse(isSymmetric(eight));
    }

    @Test
    public void isNotSymmetric() {
        Node eight = new Node(8);
        Node four = new Node(4);
        Node thirteen = new Node(13);
        Node eleven1 = new Node(11);
        Node eleven2 = new Node(11);
        Node twelve1 = new Node(12);
        Node twelve2 = new Node(12);

        eight.left = four;
        eight.right = thirteen;
        four.right = eleven1;
        thirteen.left=eleven2;
        eleven1.left=twelve1;
        eleven2.right=twelve2;

        Assert.assertFalse(isSymmetric(eight));
    }

    @Test
    public void isSymmetric() {
        Node eight = new Node(8);
        Node four1 = new Node(4);
        Node four2 = new Node(4);
        Node eleven1 = new Node(11);
        Node eleven2 = new Node(11);
        Node twelve1 = new Node(12);
        Node twelve2 = new Node(12);

        eight.left = four1;
        eight.right = four2;
        four1.right = eleven1;
        four2.left = eleven2;
        eleven1.left = twelve1;
        eleven2.right = twelve2;

        Assert.assertTrue(isSymmetric(eight));
    }

    boolean isSymmetric(Node root) {
        return recursion(root.left, root.right);
    }

    boolean recursion(Node node1, Node node2) {
        if(node1==null && node2==null) {
            return true;
        } else if(node1==null || node2==null) {
            return false;
        } else if(node1.val!=node2.val) {
            return false;
        } else {
            return recursion(node1.left,node2.right)
                    && recursion(node1.right,node2.left);
        }
    }


}


