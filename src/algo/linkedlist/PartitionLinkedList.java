package algo.linkedlist;

import org.junit.Test;

public class PartitionLinkedList
{
  @Test
  public void test()
  {
    LLNode five = new LLNode(5,null);
    LLNode four = new LLNode(4, five);
    LLNode three = new LLNode(3,four);
    LLNode two = new LLNode(2,three);
    LLNode one = new LLNode(1,two);

    LLNode actual = one;
    while(actual!=null)
    {
      System.out.println(actual.item);
      actual = actual.next;
    }

    LLNode head = partition(one,4);
    System.out.println("--- PARTITION ---");

    actual = head;
    while(actual!=null)
    {
      System.out.println(actual.item);
      actual = actual.next;
    }
  }

  private LLNode partition(LLNode node, int val)
  {
    LLNode beforeStart = null;
    LLNode beforeEnd = null;
    LLNode afterStart = null;
    LLNode afterEnd = null;

    while(node!=null)
    {
      LLNode next = node.next;
      node.next = null;
      if(node.item<val)
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
