package algo.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class InsertionInALinkedList
{
  class Node
  {
    int item;
    Node next;

    public Node(int item, Node next)
    {
      this.item = item;
      this.next = next;
    }
  }

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

    Assert.assertEquals(head,insertAtTheBeginning(10,head).next);
  }

  public Node insertAtTheBeginning(int elem, Node head)
  {
    if(head!=null)
    {
      Node temp = new Node(elem,head);
      return temp;
    } else
    {
      return head;
    }
  }

}
