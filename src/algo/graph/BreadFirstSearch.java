package algo.graph;

import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *                  1
 *                  |
 *            |-5 - 2 - 6
 *            |     |
 *            |     3
 *            |    / \
 *            |---4  7
 */
public class BreadFirstSearch
{
  List<GNode> expectedSequence = new LinkedList<>();

  @Test
  public void test()
  {
    GraphGNode g = GraphBuilder.build();
    g.init();

    for(GNode node: g.nodes)
    {
      Assert.assertEquals(GNode.Status.UNDISCOVERED,node.status);
    }

    search(g,g.nodes.get(0));

    Assert.assertEquals(1,expectedSequence.get(0).value);
    Assert.assertEquals(2,expectedSequence.get(1).value);
    Assert.assertEquals(5,expectedSequence.get(2).value);
    Assert.assertEquals(3,expectedSequence.get(3).value);
    Assert.assertEquals(6,expectedSequence.get(4).value);
    Assert.assertEquals(4,expectedSequence.get(5).value);
    Assert.assertEquals(7,expectedSequence.get(6).value);

    for(GNode node: g.nodes)
    {
      Assert.assertEquals(GNode.Status.PROCESSED,node.status);
    }
  }

  void search(GraphGNode g, GNode head)
  {
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
      if(actual.status==GNode.Status.DISCOVERED)
      {
        process(actual);
        actual.status=GNode.Status.PROCESSED;
      }
      // loop through all the other one
      for(GNode n: actual.adj)
      {
        if(n.status!= GNode.Status.PROCESSED || g.isDirected)
        {
          processEdge(actual, n);
        }
        // add to the queue if not visited
        if(n.status==GNode.Status.UNDISCOVERED)
        {
          queue.add(n);
          n.parent=actual;
          n.status=GNode.Status.DISCOVERED;
        }
      }
    }
  }

  void process(GNode actual)
  {
//    System.out.println("process: "+actual.value);
    expectedSequence.add(actual);
  }

  void processEdge(GNode node1, GNode node2)
  {
//    System.out.println("edge: "+node1+" - "+node2);
  }

}

