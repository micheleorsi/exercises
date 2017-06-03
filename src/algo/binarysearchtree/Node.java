package algo.binarysearchtree;


public class Node
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
