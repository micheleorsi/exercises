package epi.chap8;

import org.junit.Test;

public class Ex_8_2_ReverseASingleSublist {

    // 4 -> 5 -> 	6 -> 3 -> 2 -> 1 -> 7 -> 10 -> NULL , 3, 6

    // 4 -> 5 -> 1 -> 2 -> 3 -> 6 -> 7-> 10

    @Test
    public void test() {
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n3 = new Node(3);
        Node n2 = new Node(2);
        Node n1 = new Node(1);
        Node n7 = new Node(7);
        Node n10 = new Node(10);

        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        n3.next = n2;
        n2.next = n1;
        n1.next = n7;
        n7.next = n10;

        revert(n4,3,6);

        Node temp = n4;
        while(temp!=null) {
            System.out.println(temp.val);
            temp=temp.next;
        }

    }

    Node revert(Node n, int s, int f) {
        Node head = n;
        Node actual = n;
        Node before = null;
        int i=1;
        while(actual!=null && i<s) {
            before = actual;
            actual = actual.next;
            i++;
        }

        // before: 5
        // actual: 6

        // reverse list
        Node prev = null;
        Node first = actual; // 6

        while(actual!=null && i<=f) {
            Node next = actual.next; // 3
            actual.next = prev; //
            prev = actual; // 6
            actual = next; // 3
            i++;
        }

        // actual: 7
        // prev: 6
        // i: 7

        // link
        first.next = actual;
        before.next = prev;


        return head;
    }
}
