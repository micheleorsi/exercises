package algo.binarysearchtree;

import org.junit.Assert;
import org.junit.Test;

public class InsertionInATree
{
  /**
   *            8
   *        /       \
   *       4         12
   *    /    \     /    \
   *   2     6    10    14
   *  / \   / \  / \   /   \
   * 1  3  5  7 9  11 13  15
   */
  @Test
  public void test()
  {
    BSTNode root = BSTBuilder.getRoot();
    Assert.assertEquals(7,root.left.right.right.value);
    root.left.right.right = null;
    Assert.assertEquals(-1,new SearchInATree().search(7,root));
    
    insert(7,root,null);
    Assert.assertEquals(7,new SearchInATree().search(7,root));

  }

  private BSTNode insert(int num, BSTNode actual, BSTNode parent)
  {
    if(actual==null)
    {
      return new BSTNode(num,parent,null,null);
    } else if(num>actual.value) {
      actual.right = insert(num,actual.right,actual);
    }
    else if(num<actual.value){
      actual.left = insert(num, actual.left,actual);
    }
    return actual;
  }
}
