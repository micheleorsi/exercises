package algo.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class DeletionFromAList
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

    Node newHead = deleteFromList(5,head);
    Assert.assertEquals(6,newHead.next.next.next.next.item);
    newHead = deleteFromList(1,head);
    Assert.assertEquals(2,newHead.item);
  }

  Node deleteFromList(int elem, Node head)
  {
    if(head.item==elem)
    {
      return head.next;
    }
    Node prev = null;
    Node newHead = head;
    while(head!=null)
    {
      if(head.item==elem && prev!=null)
      {
        prev.next = head.next;
      }
      prev = head;
      head = head.next;
    }
    return newHead;
  }

}
