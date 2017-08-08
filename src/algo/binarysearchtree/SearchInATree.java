package algo.binarysearchtree;

import org.junit.Assert;
import org.junit.Test;

public class SearchInATree
{

  @Test
  public void test()
  {
    BSTNode root = BSTBuilder.getRoot();

    Assert.assertEquals(-1,search(100,root));
    Assert.assertEquals(6,search(6,root));
    Assert.assertEquals(2,search(2,root));
  }

  public int search(int value, BSTNode node)
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
