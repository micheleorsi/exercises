package algo.binarysearchtree;

import org.junit.Assert;
import org.junit.Test;

public class DeletingFromATree
{
  /**
   *            8
   *        /       \
   *       4         12
   *    /    \     /    \
   *   2     6    10    14
   *  / \   /   / \   /   \
   * 1  3  5   9  11 13  15
   */
  @Test
  public void test()
  {
    BSTNode root = BSTBuilder.getRoot();
    Assert.assertEquals(7,root.left.right.right.value);
    root.left.right.right=null;
    delete(5,root,null);
  }

  private void delete(int num, BSTNode node, BSTNode parent)
  {
    if(node.value==num)
    {

    }

  }
}
