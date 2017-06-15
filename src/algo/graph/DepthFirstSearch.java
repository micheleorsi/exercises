package algo.graph;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearch
{

  @Test
  public void test()
  {
    Graph g = GraphBuilder.build();
    searchStack(g,g.nodes.get(0));
  }

  void searchStack(Graph g, Node head)
  {
    // init all the nods to UNVISITED
    for(Node n: g.nodes)
    {
      n.status = Status.UNVISITED;
    }

    // init stack
    Stack<Node> stack = new Stack<>();
    // add root to the stack
    stack.push(head);

    // while the queue is not empty
    while(!stack.isEmpty())
    {
      // extract last from the stack
      Node actual = stack.pop();
      // visit if it is not already visited
      if(actual.status!=Status.VISITED)
      {
        visit(actual);
      }
      // loop through all the other one
      for(Node n: actual.adj)
      {
        if(n.status!=Status.VISITED)
        {
          stack.push(n);
        }
      }
      // mark as visited
      actual.status = Status.VISITED;
    }

  }

  private void visit(Node actual)
  {
    System.out.println(actual.value);
  }
}
