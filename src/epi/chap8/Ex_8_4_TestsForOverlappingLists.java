package epi.chap8;

import org.junit.Assert;
import org.junit.Test;

public class Ex_8_4_TestsForOverlappingLists {

    @Test
    public void testNoCommon() {
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

        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        n11.next = n12;
        n12.next = n13;

        Assert.assertNull(common(n11,n4));
    }

    @Test
    public void testCommon() {
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

        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        n11.next = n12;
        n12.next = n13;
        n13.next=n3;

        Assert.assertEquals(n3,common(n11,n4));
    }

    Node common(Node n1, Node n2) {
        Node head1 = n1;
        Node head2 = n2;

        Node actual = n1;
        int size1 = 0;
        while(actual!=null) {
            actual = actual.next;
            size1++;
        }
        actual = n2;
        int size2 = 0;
        while(actual!=null) {
            actual = actual.next;
            size2++;
        }
        int diff = Math.abs(size1-size2);
        if(size1>size2) {
            while(diff>0) {
                head1=head1.next;
                diff--;
            }
        } else {
            while(diff>0) {
                head2=head2.next;
                diff--;
            }
        }
        while(head1!=null && head2!=null) {
            if(head1==head2) {
                return head1;
            } else {
                head1=head1.next;
                head2=head2.next;
            }
        }

        return null;

    }
}
