package algo.binarysearchtree;

import org.junit.Assert;
import org.junit.Test;

public class SearchInATree
{

  class Node
  {
    int value;
    Node parent;
    Node left;
    Node right;

    public Node(int value, Node parent, Node left, Node right)
    {
      this.value = value;
      this.parent = parent;
      this.left = left;
      this.right = right;
    }
  }

  /**
   *    5
   *  /   \
   *  3   8
   * / \  / \
   * 2 4  6 9
   *
   */
  @Test
  public void test()
  {
    Node root = new Node(5,null,null,null);

    Node three = new Node(3,root,null,null);
    Node two = new Node(2,three,null,null);
    Node four = new Node(4,three,null,null);
    three.left = two;
    three.right = four;

    Node eight = new Node(8,root,null,null);
    Node six = new Node(6,eight,null,null);
    Node nine = new Node(9,eight,null,null);
    eight.left = six;
    eight.right = nine;

    root.left = three;
    root.right = eight;

    Assert.assertEquals(-1,search(10,root));
    Assert.assertEquals(6,search(6,root));
    Assert.assertEquals(2,search(2,root));
  }

  private int search(int value, Node node)
  {
    if(node==null)
    {
      return -1;
    }
    if(value==node.value)
    {
      return node.value;
    }
    if(value>node.value)
    {
      return search(value, node.right);
    } else
    {
      return search(value, node.left);
    }
  }

}
