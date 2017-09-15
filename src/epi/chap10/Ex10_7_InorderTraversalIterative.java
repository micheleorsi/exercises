package epi.chap10;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    int val;
}
public class Ex10_7_InorderTraversalIterative {


    @Test
    public void test() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node eleven = new Node(11);
        Node twelve = new Node(12);
        Node thirteen = new Node(13);
        Node fourteen = new Node(14);
        Node fifteen = new Node(15);
        Node sixteen = new Node(16);
        Node seventeen = new Node(17);

        seven.left=six;
        six.left=four;
        four.left=two;
        four.right=five;
        two.left=one;
        two.right=three;

        seven.right=thirteen;
        thirteen.left=twelve;
        thirteen.right=fourteen;
        twelve.left=nine;
        nine.left=eight;
        nine.right=ten;
        ten.right=eleven;

        fourteen.right=sixteen;
        sixteen.left=fifteen;
        sixteen.right=seventeen;

        List<Integer> nodes = inorderTraversal(seven);
        for (int i=1; i<nodes.size(); i++) {
            if(nodes.get(i)<nodes.get(i-1)) {
                Assert.fail();
            }
        }

    }

    List<Integer> inorderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        List<Integer> list = new ArrayList<>();

        while(!stack.isEmpty() || current!=null) {
            if(current!=null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                list.add(current.val);
                current = current.right;
            }
        }
        return list;
    }
}
