package algo.linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class DeleteANodeInTheMiddle
{

  @Test
  public void test()
  {
    Node<Integer> one = new Node(1);
    Node<Integer> two = new Node(2);
    Node<Integer> three = new Node(3);
    Node<Integer> four = new Node(4);
    Node<Integer> five = new Node(5);
    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;

    Assert.assertEquals(Integer.valueOf(3),two.next.data);
    deleteANode(three);

    Assert.assertEquals(Integer.valueOf(4),two.next.data);
  }

  private boolean deleteANode(Node<Integer> node)
  {
    if(node==null || node.next ==null)
    {
      return false;
    }
    node.data = node.next.data;
    node.next = node.next.next;
    return true;
  }
}
