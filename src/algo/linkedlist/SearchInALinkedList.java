package algo.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class SearchInALinkedList
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

    Assert.assertEquals(-1,searchFor(13, head));
    Assert.assertEquals(10,searchFor(10, head));

    Assert.assertEquals(-1,searchIterative(13, head));
    Assert.assertEquals(10,searchIterative(10, head));
  }

  int searchFor(int elem, Node node)
  {
    if(node==null)
    {
      return -1;
    } else if(node.item==elem)
    {
      return node.item;
    }
    else {
      return searchFor(elem, node.next);
    }
  }

  int searchIterative(int elem, Node node)
  {
    while(node!=null)
    {
      if(node.item == elem)
      {
        return node.item;
      }
      node = node.next;
    }
    return -1;
  }
}
