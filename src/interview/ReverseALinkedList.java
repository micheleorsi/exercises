package interview;

import algo.linkedlist.LLNode;
import org.junit.Test;

public class ReverseALinkedList
{

  public LLNode revert(LLNode head)
  {
    LLNode prev = null;
    LLNode actual = head;
    LLNode next = null;
    while(actual!=null)
    {
      next = actual.next;
      actual.next = prev;
      prev = actual;
      actual = next;
    }

    return prev;
  }

  public LLNode revertRecursive(LLNode node, LLNode prev)
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
    LLNode newHead = revertRecursive(node.next,node);
    node.next=prev;
    return newHead;
  }

  @Test
  public void test()
  {
    LLNode node10 = new LLNode(10,null);
    LLNode node9 = new LLNode(9,node10);
    LLNode node8 = new LLNode(8,node9);
    LLNode node7 = new LLNode(7,node8);
    LLNode node6 = new LLNode(6,node7);
    LLNode node5 = new LLNode(5,node6);
    LLNode node4 = new LLNode(4,node5);
    LLNode node3 = new LLNode(3,node4);
    LLNode node2 = new LLNode(2,node3);
    LLNode node1 = new LLNode(1,node2);

    System.out.println("normal list");
    printList(node1);
    LLNode newHead = revertRecursive(node1,null);
    System.out.println("reverted list");
    printList(newHead);

  }

  void printList(LLNode node)
  {
    while(node!=null)
    {
      System.out.println(node.item);
      node = node.next;
    }
  }
}
