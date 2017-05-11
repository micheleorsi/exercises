package interview;

import org.junit.Test;

public class ReverseALinkedList
{

  public Node revert(Node head)
  {
    Node prev = null;
    Node actual = head;
    Node next = null;
    while(actual!=null)
    {
      next = actual.next;
      actual.next = prev;
      prev = actual;
      actual = next;
    }

    return prev;
  }

  public Node revertRecursive(Node node, Node prev)
  {
    if(node==null)
    {
      return null;
    }
    if(node.next == null)
    {
      // this is the new head
      node.next = prev;
      return node;
    }
    Node newHead = revertRecursive(node.next,node);
    node.next=prev;
    return newHead;
  }

  class Node {
    int value;
    Node next;

    public Node(int value,Node next)
    {
      this.value = value;
      this.next = next;
    }
  }

  @Test
  public void test()
  {
    Node node10 = new Node(10,null);
    Node node9 = new Node(9,node10);
    Node node8 = new Node(8,node9);
    Node node7 = new Node(7,node8);
    Node node6 = new Node(6,node7);
    Node node5 = new Node(5,node6);
    Node node4 = new Node(4,node5);
    Node node3 = new Node(3,node4);
    Node node2 = new Node(2,node3);
    Node node1 = new Node(1,node2);

    System.out.println("normal list");
    printList(node1);
    Node newHead = revertRecursive(node1,null);
    System.out.println("reverted list");
    printList(newHead);

  }

  void printList(Node node)
  {
    while(node!=null)
    {
      System.out.println(node.value);
      node = node.next;
    }
  }
}
