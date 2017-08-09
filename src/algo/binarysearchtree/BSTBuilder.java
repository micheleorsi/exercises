package algo.binarysearchtree;

import org.junit.Assert;
import org.junit.Test;

public class BSTBuilder
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
  public static BSTNode getRoot()
  {
    BSTNode root = new BSTNode(8,null,null,null);

    BSTNode twelve = new BSTNode(12,root,null,null);
    BSTNode ten = new BSTNode(10,twelve,null,null);
    BSTNode fourteen = new BSTNode(14,twelve,null,null);
    twelve.left = ten;
    twelve.right = fourteen;

    BSTNode nine = new BSTNode(9,ten,null,null);
    BSTNode eleven = new BSTNode(11,ten,null,null);
    BSTNode thirteen = new BSTNode(13,fourteen,null,null);
    BSTNode fifteen = new BSTNode(15,fourteen,null,null);
    ten.left = nine;
    ten.right = eleven;
    fourteen.left = thirteen;
    fourteen.right = fifteen;


    BSTNode four = new BSTNode(4,root,null,null);
    BSTNode two = new BSTNode(2,four,null,null);
    BSTNode six = new BSTNode(6,four,null,null);
    BSTNode one = new BSTNode(1,two,null,null);
    BSTNode three = new BSTNode(3,two,null,null);
    BSTNode five = new BSTNode(5,six,null,null);
    BSTNode seven = new BSTNode(7,six,null,null);
    two.left = one;
    two.right = three;
    six.left = five;
    six.right = seven;
    four.left = two;
    four.right = six;

    root.left = four;
    root.right = twelve;
    return root;
  }

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
    BSTNode head = BSTBuilder.getRoot();
    Assert.assertEquals(8,head.value);
    Assert.assertEquals(4,head.left.value);
    Assert.assertEquals(2,head.left.left.value);
    Assert.assertEquals(1,head.left.left.left.value);

    Assert.assertEquals(12,head.right.value);
    Assert.assertEquals(14,head.right.right.value);
    Assert.assertEquals(15,head.right.right.right.value);

    Assert.assertEquals(6,head.left.right.value);
  }
}
