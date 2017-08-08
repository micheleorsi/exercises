package algo.graph;

import org.junit.Test;

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

  void search(Graph g, GNode head)
  {
    // init all the nods to UNVISITED
    for(GNode n: g.nodes)
    {
      n.status = Status.UNVISITED;
    }

    // init queue
    Queue<GNode> queue = new LinkedList<>();
    // add root to the queue (at the end)
    queue.add(head);

    // while the queue is not empty
    while (!queue.isEmpty())
    {
      // extract first from the queue
      GNode actual = queue.remove();
      // visit
      visit(actual);
      // loop through all the other one
      for(GNode n: actual.adj)
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

  private void visit(GNode head)
  {
    System.out.println(head.value);
  }

}

class Graph
{
  List<GNode> nodes;
}

class GNode
{
  int value;
  List<GNode> adj;
  Status status;

  public GNode(int value)
  {
    this.value = value;
  }
}

enum Status
{
  UNVISITED, VISITED;
}
