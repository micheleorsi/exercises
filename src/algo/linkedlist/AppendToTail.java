package algo.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class AppendToTail
{

  @Test
  public void test()
  {
    Node root = new Node(1,null);
    Node newNode = new Node(2,null);
    appendToTail(root,newNode);
    Assert.assertEquals(newNode,root.next);
  }

  private void appendToTail(Node root, Node newNode)
  {
    Node actual = root;
    while(actual.next!=null)
    {
      actual = actual.next;
    }
    actual.next = newNode;
  }
}
