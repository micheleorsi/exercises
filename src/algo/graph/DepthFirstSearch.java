package algo.graph;

import org.junit.Test;
import java.util.Stack;

public class DepthFirstSearch
{

  @Test
  public void test()
  {
    Graph g = GraphBuilder.build();
    System.out.print("A: ");
    searchStack(g,g.nodes.get(0));
    System.out.println("\nE: 1, 2, 6, 3, 7, 4, 5");
  }

  void searchStack(Graph g, GNode head)
  {
    // init all the nods to UNVISITED
    for(GNode n: g.nodes) {
      n.status = GNode.Status.UNDISCOVERED;
    }

    // init stack
    Stack<GNode> stack = new Stack<>();
    // add root to the stack
    stack.push(head);
    head.status= GNode.Status.DISCOVERED;

    // while the queue is not empty
    while(!stack.isEmpty())
    {
      // extract last from the stack
      GNode actual = stack.pop();
      // visit if it is not already visited
      if(actual.status== GNode.Status.DISCOVERED)
      {
        visit(actual);
        actual.status= GNode.Status.PROCESSED;
      }
      // loop through all the other one
      for(GNode n: actual.adj)
      {
        if(n.status== GNode.Status.UNDISCOVERED)
        {
          stack.push(n);
          n.status= GNode.Status.DISCOVERED;
        }
      }
    }

  }

  private void visit(GNode actual)
  {
    System.out.print(actual.value+", ");
  }
}
