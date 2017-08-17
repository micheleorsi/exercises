package algo.graph;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch
{
  Graph<GNode> g;
  List<GNode> nodeSeq;
  List<String> edgeSeq;

  @Before
  public void setup()
  {
    nodeSeq = new LinkedList<>();
    edgeSeq = new LinkedList<>();

    g = Graph.Builder.buildWithCycle();
    g.init();

    for(GNode node: g.nodes)
    {
      Assert.assertEquals(GNode.Status.UNDISCOVERED,node.status);
    }
  }

  @After
  public void after()
  {

    for(GNode node: g.nodes)
    {
      Assert.assertEquals(GNode.Status.PROCESSED,node.status);
      System.out.println(node);
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
  public void testStack()
  {

    DFSStack dfsStack = new DFSStack(nodeSeq, edgeSeq);

    dfsStack.search(g,g.nodes.get(0));

    Assert.assertEquals(7, nodeSeq.size());

    Assert.assertEquals(1, nodeSeq.get(0).value);
    Assert.assertEquals(2, nodeSeq.get(1).value);
    Assert.assertEquals(6, nodeSeq.get(2).value);
    Assert.assertEquals(3, nodeSeq.get(3).value);
    Assert.assertEquals(7, nodeSeq.get(4).value);
    Assert.assertEquals(4, nodeSeq.get(5).value);
    Assert.assertEquals(5, nodeSeq.get(6).value);

    Assert.assertEquals(7, edgeSeq.size());

    Assert.assertEquals("1-2", edgeSeq.get(0));
    Assert.assertEquals("2-5", edgeSeq.get(1));
    Assert.assertEquals("2-3", edgeSeq.get(2));
    Assert.assertEquals("2-6", edgeSeq.get(3));
    Assert.assertEquals("3-4", edgeSeq.get(4));
    Assert.assertEquals("3-7", edgeSeq.get(5));
    Assert.assertEquals("4-5", edgeSeq.get(6));
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
  public void testRecursive()
  {
    DFSRecursive dfsRecursive = new DFSRecursive(nodeSeq, edgeSeq);

    dfsRecursive.search(g,g.nodes.get(0));

    Assert.assertEquals(7, nodeSeq.size());

    Assert.assertEquals(1, nodeSeq.get(0).value);
    Assert.assertEquals(2, nodeSeq.get(1).value);
    Assert.assertEquals(5, nodeSeq.get(2).value);
    Assert.assertEquals(4, nodeSeq.get(3).value);
    Assert.assertEquals(3, nodeSeq.get(4).value);
    Assert.assertEquals(7, nodeSeq.get(5).value);
    Assert.assertEquals(6, nodeSeq.get(6).value);

    Assert.assertEquals(7, edgeSeq.size());
    Assert.assertEquals("1-2", edgeSeq.get(0));
    Assert.assertEquals("2-5", edgeSeq.get(1));
    Assert.assertEquals("5-4", edgeSeq.get(2));
    Assert.assertEquals("4-3", edgeSeq.get(3));
    Assert.assertEquals("3-2", edgeSeq.get(4));
    Assert.assertEquals("3-7", edgeSeq.get(5));
    Assert.assertEquals("2-6", edgeSeq.get(6));
  }

}

class DFSRecursive extends AbstractGS {

  List<GNode> nodeSeq;
  List<String> edgeSeq;

  int time=0;

  boolean isFinished = false;

  public DFSRecursive(List<GNode> nodeSeq, List<String> edgeSeq) {
    this.nodeSeq = nodeSeq;
    this.edgeSeq = edgeSeq;
  }

  @Override
  public <T> void search(Graph g, GNode<T> actual)
  {
    if(isFinished)
      return;

    actual.status= GNode.Status.DISCOVERED;
    time++;
    actual.entryTime=time;

    processEarly(nodeSeq,actual);

    for(GNode n: actual.adj)
    {
      if(n.status== GNode.Status.UNDISCOVERED)
      {
        n.parent = actual;
        processEdge(edgeSeq,actual,n);
        search(g, n);
      }
      else if((n.status== GNode.Status.DISCOVERED && actual.parent!=n)|| g.isDirected) {
        processEdge(edgeSeq,actual,n);
        if(isFinished)
          return;
      }
    }

    processLate(nodeSeq,actual);

    time++;
    actual.exitTime=time;
    actual.status= GNode.Status.PROCESSED;
  }
}

class DFSStack extends AbstractGS {

  List<GNode> nodeSeq;
  List<String> edgeSeq;

  public DFSStack(List<GNode> nodeSeq, List<String> edgeSeq) {
    this.nodeSeq = nodeSeq;
    this.edgeSeq = edgeSeq;
  }

  @Override
  public <T> void search(Graph g, GNode<T> head)
  {

    // init stack
    Stack<GNode> stack = new Stack<>();
    // add root to the stack
    stack.push(head);
    head.status= GNode.Status.DISCOVERED;

    // while the queue is not empty
    while(!stack.isEmpty())
    {
      // extract last from the stack
      GNode<T> actual = stack.pop();
      // process if it is not already visited
      processEarly(nodeSeq,actual);
      actual.status= GNode.Status.PROCESSED;

      // loop through all the other one
      for(GNode n: actual.adj)
      {
        if(n.status!= GNode.Status.PROCESSED || g.isDirected)
        {
          processEdge(edgeSeq,actual, n);
        }
        if(n.status== GNode.Status.UNDISCOVERED)
        {
          stack.push(n);
          n.parent=actual;
          n.status= GNode.Status.DISCOVERED;
        }
      }


    }

  }
}
