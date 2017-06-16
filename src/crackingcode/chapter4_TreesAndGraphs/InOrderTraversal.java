package crackingcode.chapter4_TreesAndGraphs;

import org.junit.Test;

public class InOrderTraversal
{


  @Test
  public void test()
  {

  }

  public void inOrderTraversal(BinaryNode n)
  {
    if(n!=null)
    {
      inOrderTraversal(n.left);
      System.out.println(n.name);
      inOrderTraversal(n.right);
    }
  }

  public void preOrderTraversal(BinaryNode n)
  {
    if(n!=null)
    {
      System.out.println(n.name);
      inOrderTraversal(n.left);
      inOrderTraversal(n.right);
    }
  }

  public void postOrderTraversal(BinaryNode n)
  {
    if(n!=null)
    {
      inOrderTraversal(n.left);
      inOrderTraversal(n.right);
      System.out.println(n.name);
    }
  }

}
