package algo.binarysearchtree;

import org.junit.Test;

public class TraversalTree
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
    System.out.println("order traversal");
    orderTraversal(BSTBuilder.getRoot());
    System.out.println("\npre-order traversal");
    preorderTraversal(BSTBuilder.getRoot());
    System.out.println("\npost-order traversal");
    postorderTraversal(BSTBuilder.getRoot());
  }

  private void postorderTraversal(BSTNode root)
  {
    if(root!=null)
    {
      postorderTraversal(root.left);
      postorderTraversal(root.right);
      process(root);
    }
  }

  private void preorderTraversal(BSTNode root)
  {
    if(root!=null)
    {
      process(root);
      preorderTraversal(root.left);
      preorderTraversal(root.right);
    }
  }

  public void orderTraversal(BSTNode node)
  {
    if(node!=null)
    {
      orderTraversal(node.left);
      process(node);
      orderTraversal(node.right);
    }
  }

  public void process(BSTNode node)
  {
    System.out.println(node.value);
  }
}
