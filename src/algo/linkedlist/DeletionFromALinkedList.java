package algo.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class DeletionFromALinkedList
{

  @Test
  public void test()
  {
    Node n10 = new Node(10,null);
    Node n9 = new Node(9,n10);
    Node n8 = new Node(8,n9);
    Node n7 = new Node(7,n8);
    Node n6 = new Node(6,n7);
    Node n5 = new Node(5,n6);
    Node n4 = new Node(4,n5);
    Node n3 = new Node(3,n4);
    Node n2 = new Node(2,n3);
    Node head = new Node(1,n2);

    Node newHead = deleteFromLinkedList(5,head);
    Assert.assertEquals(6,newHead.next.next.next.next.item);
    newHead = deleteFromLinkedList(1,head);
    Assert.assertEquals(2,newHead.item);

    newHead = deleteFromLinkedList(1,null);
    Assert.assertNull(newHead);
    newHead = deleteFromLinkedList(1,n10);
    Assert.assertNull(newHead);
  }

  Node deleteFromLinkedList(int elem, Node head)
  {
    if(head==null || head.next==null)
    {
      return null;
    }
    if(head.item==elem)
    {
      return head.next;
    }
    Node n = head;
    while(n.next!=null)
    {
      if(n.next.item==elem)
      {
        n.next = n.next.next;
      }
      n = n.next;
    }
    return head;
  }

}
