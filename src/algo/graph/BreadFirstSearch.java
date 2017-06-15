package algo.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadFirstSearch
{

  //
  @Test
  public void test()
  {

    Graph g = GraphBuilder.build();
    search(g,g.nodes.get(0));
  }

  void search(Graph g, Node head)
  {
    // init all the nods to UNVISITED
    for(Node n: g.nodes)
    {
      n.status = Status.UNVISITED;
    }

    // init queue
    Queue<Node> queue = new LinkedList<>();
    // add root to the queue (at the end)
    queue.add(head);

    // while the queue is not empty
    while (!queue.isEmpty())
    {
      // extract first from the queue
      Node actual = queue.remove();
      // visit
      visit(actual);
      // loop through all the other one
      for(Node n: actual.adj)
      {
        // add to the queue if not visited
        if(n.status!=Status.VISITED)
        {
          queue.add(n);
        }
      }
      // mark as visited
      actual.status = Status.VISITED;
    }

  }

  private void visit(Node head)
  {
    System.out.println(head.value);
  }

}

class Graph
{
  List<Node> nodes;
}

class Node
{
  int value;
  List<Node> adj;
  Status status;

  public Node(int value)
  {
    this.value = value;
  }
}

enum Status
{
  UNVISITED, VISITED;
}
