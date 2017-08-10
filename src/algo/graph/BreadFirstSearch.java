package algo.graph;

import org.junit.Test;
import java.util.LinkedList;
import java.util.Queue;

public class BreadFirstSearch
{
  @Test
  public void test()
  {
    Graph g = GraphBuilder.build();
    System.out.print("A: ");
    search(g,g.nodes.get(0));
    System.out.println("\nE: 1, 2, 5, 3, 6, 4, 7");
  }

  void search(Graph g, GNode head)
  {
    // init all the nods to UNDISCOVERED
    for(GNode n: g.nodes) {
      n.status = GNode.Status.UNDISCOVERED;
    }

    // init queue
    Queue<GNode> queue = new LinkedList<>();
    // add root to the queue (at the end)
    queue.add(head);
    head.status= GNode.Status.DISCOVERED;

    // while the queue is not empty
    while (!queue.isEmpty()) {
      // extract first from the queue
      GNode actual = queue.remove();
      // process
      if(actual.status== GNode.Status.DISCOVERED)
      {
        process(actual);
        head.status= GNode.Status.PROCESSED;
      }
      // loop through all the other one
      for(GNode n: actual.adj)
      {
        // add to the queue if not visited
        if(n.status==GNode.Status.UNDISCOVERED)
        {
          queue.add(n);
          n.status= GNode.Status.DISCOVERED;
        }
      }
    }

  }

  private void process(GNode head)
  {
    System.out.print(head.value+", ");
  }

}

