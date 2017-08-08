package algo.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class AppendToTail
{

  @Test
  public void test()
  {
    LLNode root = new LLNode(1,null);
    LLNode newNode = new LLNode(2,null);
    appendToTail(root,newNode);
    Assert.assertEquals(newNode,root.next);
  }

  private void appendToTail(LLNode root, LLNode newNode)
  {
    LLNode actual = root;
    while(actual.next!=null)
    {
      actual = actual.next;
    }
    actual.next = newNode;
  }
}
