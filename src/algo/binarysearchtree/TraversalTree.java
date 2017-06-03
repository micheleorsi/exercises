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
    System.out.println("pre-order traversal");
    preorderTraversal(BSTBuilder.getRoot());
    System.out.println("post-order traversal");
    postorderTraversal(BSTBuilder.getRoot());
  }

  private void postorderTraversal(Node root)
  {
    if(root!=null)
    {
      postorderTraversal(root.left);
      postorderTraversal(root.right);
      process(root);
    }
  }

  private void preorderTraversal(Node root)
  {
    if(root!=null)
    {
      process(root);
      preorderTraversal(root.left);
      preorderTraversal(root.right);
    }
  }

  public void orderTraversal(Node node)
  {
    if(node!=null)
    {
      orderTraversal(node.left);
      process(node);
      orderTraversal(node.right);
    }
  }

  public void process(Node node)
  {
    System.out.println(node.value);
  }
}
