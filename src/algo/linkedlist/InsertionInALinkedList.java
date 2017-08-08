package algo.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class InsertionInALinkedList
{

  @Test
  public void test()
  {
    LLNode n10 = new LLNode(10,null);
    LLNode n9 = new LLNode(9,n10);
    LLNode n8 = new LLNode(8,n9);
    LLNode n7 = new LLNode(7,n8);
    LLNode n6 = new LLNode(6,n7);
    LLNode n5 = new LLNode(5,n6);
    LLNode n4 = new LLNode(4,n5);
    LLNode n3 = new LLNode(3,n4);
    LLNode n2 = new LLNode(2,n3);
    LLNode head = new LLNode(1,n2);

    Assert.assertEquals(head,insertAtTheBeginning(10,head).next);
  }

  public LLNode insertAtTheBeginning(int elem, LLNode head)
  {
    if(head!=null)
    {
      LLNode temp = new LLNode(elem,head);
      return temp;
    } else
    {
      return head;
    }
  }

}
