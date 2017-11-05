package epi.chap8;

import org.junit.Test;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}



public class Ex8_1_MergeTwoSortedList {

    @Test
    public void test() {
        Node n1 = new Node(1);
        Node n4 = new Node(4);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n7_2 = new Node(7);
        n1.next=n4;
        n4.next=n6;
        n6.next=n7;
        n7.next=n7_2;

        Node minus1 = new Node(-1);
        Node five = new Node(5);
        Node sixteen = new Node(16);
        Node seventeen = new Node(17);
        Node seventy = new Node(70);
        minus1.next=five;
        five.next=sixteen;
        sixteen.next=seventeen;
        seventeen.next=seventy;

        Node newHead = mergeList(n1,minus1);
        while(newHead!=null) {
            System.out.println(newHead.val);
            newHead=newHead.next;
        }

        System.out.println();

        newHead = mergeList2(n1,minus1);
        while(newHead!=null) {
            System.out.println(newHead.val);
            newHead=newHead.next;
        }

    }

    Node mergeList2(Node l1, Node l2) {
        Node head = new Node(0);
        Node root = head;

        while(l1!=null && l2!=null) {
            if(l1.val<l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head=head.next;
        }

        while(l1!=null) {
            head.next = l1;
            l1 = l1.next;
            head=head.next;
        }

        while(l2!=null) {
            head.next = l2;
            l2 = l2.next;
            head=head.next;
        }

        return root.next;
    }

    Node mergeList(Node l1, Node l2) {
        Node head = new Node(0);
        Node root = head;

        while(l1!=null && l2!=null) {
            if(l1.val<l2.val) {
                Node n = new Node(l1.val);
                head.next = n;
                head = head.next;
                l1 = l1.next;
            } else {
                Node n = new Node(l2.val);
                head.next = n;
                head = head.next;
                l2 = l2.next;
            }
        }
        // finish with the rest
        while(l1!=null) {
            Node n = new Node(l1.val);
            head.next = n;
            head = head.next;
            l1 = l1.next;
        }

        while(l2!=null) {
            Node n = new Node(l2.val);
            head.next = n;
            head = head.next;
            l2 = l2.next;
        }


        // remove head before return!!!
        return root.next;
    }

}
