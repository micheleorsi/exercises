package interview;


import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class CommonAncestor {

    //              Grandma1
    //              /       \
    //           parent1    parent2
    //          /            /  \
    //      Alice       another parent
    //                            \
    //                            Bob
    //

    @Test
    public void test1() {
        Node n1 = new Node("Grandma1");
        Node parent1 = new Node("parent1");
        Node alice = new Node("Alice");
        Node parent2 = new Node("parent2");
        Node another = new Node("another");
        Node parent = new Node("parent");
        Node bob = new Node("Bob");

        n1.left = parent1;
        parent1.left = alice;

        n1.right = parent2;
        parent2.left = another;
        parent2.right = parent;

        parent.right = bob;

        Node anc = closest1(n1,alice,bob);
        Assert.assertEquals(anc.name,"Grandma1");

    }

    //              Grandma1
    //              /       \
    //           parent1    parent2
    //          /            /  \
    //      child       Alice parent
    //                            \
    //                            Bob
    //
    @Test
    public void test2() {
        Node grandma1 = new Node("Grandma1");
        Node parent1 = new Node("parent1");
        Node child = new Node("child");

        Node parent2 = new Node("parent2");
        Node alice = new Node("Alice");
        Node parent = new Node("parent");
        Node bob = new Node("Bob");

        grandma1.left = parent1;
        parent1.left = child;

        grandma1.right = parent2;
        parent2.left = alice;
        parent2.right = parent;

        parent.right = bob;

        Node anc = closest1(grandma1,alice,bob);
        Assert.assertEquals(anc.name,"parent2");

    }

    class Node {
        String name;
        Node left;
        Node right;

        Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    Node closest1(Node root, Node n1, Node n2) {
        List<Node> n1list = recursion(root, n1);
        List<Node> n2list = recursion(root, n2);

//        System.out.println(n1list);
//        System.out.println(n2list);

        return findAncestor(n1list, n2list);
    }



    // linear with number of nodes
    List<Node> recursion(Node root, Node n1) {
        if(root!=null) {
            if(root.name==n1.name) {
                List<Node> n = new LinkedList<Node>();
                n.add(root);
                return n;
            }
            List<Node> n = recursion(root.left,n1);
            if(n!=null) {
                n.add(root);
                return n;
            }
            n = recursion(root.right,n1);
            if(n!=null) {
                n.add(root);
                return n;
            }
            return null;
        } else {
            return null;
        }
    }

    // linear with ancestor << nodes
    Node findAncestor(List<Node> list1, List<Node> list2) {
        int i =list1.size()-1; int j=list2.size()-1;
        Node ancestor = list1.get(i);
        while(i>=0 && j>=0) {
            if(list1.get(i)!=list2.get(j)) {
                return ancestor;
            } else {
                ancestor = list1.get(i);
            }

            i--;
            j--;
        }
        return null;
    }

    // another working solution
    // linear with ancestor << nodes
//    Node findAncestor(List<Node> list1, List<Node> list2) {
//        int diff = Math.abs(list1.size()-list2.size());
//
//        int idx1 = 0;
//        int idx2 = 0;
//
//        if(list1.size()>list2.size()) {
//            idx1+=diff;
//        } else {
//            idx2+=diff;
//        }
//
//        while(idx1 < list1.size() && idx2 < list2.size()) {
//            if(list1.get(idx1) == list2.get(idx2)) {
//                return list1.get(idx1);
//            }
//            idx1++;
//            idx2++;
//        }
//        return null;
//    }

}
