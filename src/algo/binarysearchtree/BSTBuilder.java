package algo.binarysearchtree;

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
  public static Node getRoot()
  {
    Node root = new Node(8,null,null,null);

    Node twelve = new Node(12,root,null,null);
    Node ten = new Node(10,twelve,null,null);
    Node fourteen = new Node(14,twelve,null,null);
    twelve.left = ten;
    twelve.right = fourteen;

    Node nine = new Node(9,ten,null,null);
    Node eleven = new Node(11,ten,null,null);
    Node thirteen = new Node(13,fourteen,null,null);
    Node fifteen = new Node(15,fourteen,null,null);
    ten.left = nine;
    ten.right = eleven;
    fourteen.left = thirteen;
    fourteen.right = fifteen;


    Node four = new Node(4,root,null,null);
    Node two = new Node(2,four,null,null);
    Node six = new Node(6,four,null,null);
    Node one = new Node(1,two,null,null);
    Node three = new Node(3,two,null,null);
    Node five = new Node(5,six,null,null);
    Node seven = new Node(7,six,null,null);
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
}
