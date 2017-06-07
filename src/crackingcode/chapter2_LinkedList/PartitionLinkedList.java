package crackingcode.chapter2_LinkedList;

import org.junit.Test;

public class PartitionLinkedList
{
  @Test
  public void test()
  {
    Node<Integer> one = new Node(1);
    Node<Integer> three = new Node(3);
    Node<Integer> five = new Node(5);
    Node<Integer> four = new Node(4);
    Node<Integer> two = new Node(2);
    one.next = three;
    three.next = five;
    five.next = four;
    four.next = two;

    Node actual = one;
    while(actual!=null)
    {
      System.out.println(actual.data);
      actual = actual.next;
    }

    Node head = partition(one,4);
    System.out.println("--- PARTITION ---");

    actual = head;
    while(actual!=null)
    {
      System.out.println(actual.data);
      actual = actual.next;
    }

  }

  private Node partition(Node<Integer> node, int val)
  {
    Node beforeStart = null;
    Node beforeEnd = null;
    Node afterStart = null;
    Node afterEnd = null;

    while(node!=null)
    {
      Node next = node.next;
      node.next = null;
      if(node.data<val)
      {
        if(beforeStart==null)
        {
          beforeStart=node;
          beforeEnd=beforeStart;
        }
        else{
          beforeEnd.next = node;
          beforeEnd = node;
        }
      }
      else // >=
      {
        if(afterStart==null)
        {
          afterStart=node;
          afterEnd = afterStart;
        }
        else
        {
          afterEnd.next = node;
          afterEnd = node;
        }
      }
      node = next;
    }
    if(beforeStart==null)
    {
      return afterStart;
    }
    beforeEnd.next = afterStart;
    return beforeStart;
  }
}
