package epi.chap8;

import org.junit.Assert;
import org.junit.Test;

public class Ex_8_3_TestCyclicity {

    @Test
    public void testNoCycle() {
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
        n10.next = null;

        Assert.assertNull(cycle(n4));
    }

    @Test
    public void testCycle() {
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
        n10.next = n3;

        Assert.assertEquals(n3,cycle(n4));
    }

    Node cycle(Node n) {
        if(n==null) {
            return null;
        }
        Node head = n;
        Node actual = n;
        Node runner = n;

        while(runner!=null && runner.next!=null) {
            runner = runner.next.next;
            actual = actual.next;
            if(runner==actual) {
                break;
            }
        }

        if(runner!=actual) {
            return null;
        }

        // we have a cycle
        actual = head;
        while(runner!=actual) {
            runner = runner.next;
            actual = actual.next;
        }

        return actual;

    }
}
