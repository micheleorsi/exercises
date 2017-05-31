package algo.binarysearchtree;

import org.junit.Assert;
import org.junit.Test;


public class FindMinMaxInATree
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

    Assert.assertEquals(2,findMin(root));
    Assert.assertEquals(9,findMax(root));

    Assert.assertEquals(2,findMinIterative(root));
    Assert.assertEquals(9,findMaxIterative(root));
  }

  private int findMaxIterative(Node node)
  {
    Node temp = node;
    int max = temp.value;
    while(temp!=null)
    {
      max = temp.value;
      temp = temp.right;
    }
    return max;
  }

  private int findMinIterative(Node node)
  {
    Node temp = node;
    int min = temp.value;
    while(temp!=null)
    {
      min = temp.value;
      temp = temp.left;
    }
    return min;
  }

  private int findMax(Node node)
  {
    if(node.right==null)
    {
      return node.value;
    }
    else
    {
      return findMax(node.right);
    }
  }


  private int findMin(Node node)
  {
    if(node.left==null)
    {
      return node.value;
    }
    else
    {
      return findMin(node.left);
    }
  }
}
