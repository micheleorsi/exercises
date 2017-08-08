package algo.binarysearchtree;


public class BSTNode
{
  int value;
  BSTNode parent;
  BSTNode left;
  BSTNode right;

  public BSTNode(int value, BSTNode parent, BSTNode left, BSTNode right)
  {
    this.value = value;
    this.parent = parent;
    this.left = left;
    this.right = right;
  }
}
