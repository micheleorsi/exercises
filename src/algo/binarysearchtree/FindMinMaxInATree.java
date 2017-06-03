package algo.binarysearchtree;

import org.junit.Assert;
import org.junit.Test;


public class FindMinMaxInATree
{

  @Test
  public void test()
  {
    Node root = BSTBuilder.getRoot();

    Assert.assertEquals(1,findMin(root));
    Assert.assertEquals(15,findMax(root));

    Assert.assertEquals(1,findMinIterative(root));
    Assert.assertEquals(15,findMaxIterative(root));
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
