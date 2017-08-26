package algo.graph;

import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadFirstSearch
{
  /**
   *                  1
   *                  |
   *              5 - 2 - 6
   *                  |
   *                  3
   *                 / \
   *                4  7
   */
  @Test
  public void testWithoutCycle() {
    Graph<GNode> g = Graph.Builder.buildWithoutCycle();
    g.init();

    for(GNode node: g.nodes)
    {
      Assert.assertEquals(GNode.Status.UNDISCOVERED,node.status);
    }
    List<GNode> nodeSeq = new LinkedList<>();
    List<String> edgeSeq = new LinkedList<>();

    BFS bfs = new BFS(nodeSeq,edgeSeq);

    bfs.search(g,g.nodes.get(0));

    Assert.assertEquals(1, nodeSeq.get(0).value);
    Assert.assertEquals(2, nodeSeq.get(1).value);
    Assert.assertEquals(5, nodeSeq.get(2).value);
    Assert.assertEquals(3, nodeSeq.get(3).value);
    Assert.assertEquals(6, nodeSeq.get(4).value);
    Assert.assertEquals(4, nodeSeq.get(5).value);
    Assert.assertEquals(7, nodeSeq.get(6).value);

    Assert.assertEquals(6, edgeSeq.size());

    Assert.assertEquals("1-2", edgeSeq.get(0));
    Assert.assertEquals("2-5", edgeSeq.get(1));
    Assert.assertEquals("2-3", edgeSeq.get(2));
    Assert.assertEquals("2-6", edgeSeq.get(3));
    Assert.assertEquals("3-4", edgeSeq.get(4));
    Assert.assertEquals("3-7", edgeSeq.get(5));

    for(GNode node: g.nodes)
    {
      Assert.assertEquals(GNode.Status.PROCESSED,node.status);
    }

  }

  /**
   *                  1
   *                  |
   *            |-5 - 2 - 6
   *            |     |
   *            |     3
   *            |    / \
   *            |---4  7
   */
  @Test
  public void testWithCycle()
  {
    Graph<GNode> g = Graph.Builder.buildWithCycle();
    g.init();

    for(GNode node: g.nodes)
    {
      Assert.assertEquals(GNode.Status.UNDISCOVERED,node.status);
    }
    List<GNode> nodeSeq = new LinkedList<>();
    List<String> edgeSeq = new LinkedList<>();

    BFS bfs = new BFS(nodeSeq,edgeSeq);

    bfs.search(g,g.nodes.get(0));

    Assert.assertEquals(1, nodeSeq.get(0).value);
    Assert.assertEquals(2, nodeSeq.get(1).value);
    Assert.assertEquals(5, nodeSeq.get(2).value);
    Assert.assertEquals(3, nodeSeq.get(3).value);
    Assert.assertEquals(6, nodeSeq.get(4).value);
    Assert.assertEquals(4, nodeSeq.get(5).value);
    Assert.assertEquals(7, nodeSeq.get(6).value);

    Assert.assertEquals(7, edgeSeq.size());

    Assert.assertEquals("1-2", edgeSeq.get(0));
    Assert.assertEquals("2-5", edgeSeq.get(1));
    Assert.assertEquals("2-3", edgeSeq.get(2));
    Assert.assertEquals("2-6", edgeSeq.get(3));
    Assert.assertEquals("5-4", edgeSeq.get(4));
    Assert.assertEquals("3-4", edgeSeq.get(5));
    Assert.assertEquals("3-7", edgeSeq.get(6));

    for(GNode node: g.nodes)
    {
      Assert.assertEquals(GNode.Status.PROCESSED,node.status);
    }
  }
}

class BFS extends AbstractGS {

  List<GNode> nodeSeq;
  List<String> edgeSeq;

  public BFS(List<GNode> nodeSeq, List<String> edgeSeq) {
    this.nodeSeq = nodeSeq;
    this.edgeSeq = edgeSeq;
  }

  @Override
  public <T> void search(Graph g, GNode<T> head)
  {
    // init queue
    Queue<GNode> queue = new LinkedList<>();
    // add root to the queue (at the end)
    queue.add(head);
    head.status= GNode.Status.DISCOVERED;

    // while the queue is not empty
    while (!queue.isEmpty()) {
      // extract first from the queue
      GNode<T> actual = queue.remove();

      // process early
      processEarly(nodeSeq,actual);
      actual.status=GNode.Status.PROCESSED;

      // loop through all the other one
      for(GNode n: actual.adj)
      {
        if(n.status!= GNode.Status.PROCESSED || g.isDirected)
        {
          processEdge(edgeSeq,actual, n);
        }
        // add to the queue if not visited
        if(n.status==GNode.Status.UNDISCOVERED)
        {
          queue.add(n);
          n.parent=actual;
          n.status=GNode.Status.DISCOVERED;
        }
      }

      // process late
      processLate(nodeSeq,actual);

    }
  }
}

