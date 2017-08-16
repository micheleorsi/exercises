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
  List<GNode> nodeSeqStack = new LinkedList<>();
  List<GNode> nodeSeqRecursive = new LinkedList<>();
  List<String> edgeStack = new LinkedList<>();
  List<String> edgeRecursive = new LinkedList<>();
  GraphGNode g;

  @Before
  public void setup()
  {
    g = GraphBuilder.build();
    init(g);

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

    searchStack(g,g.nodes.get(0));

    Assert.assertEquals(7, nodeSeqStack.size());

    Assert.assertEquals(1, nodeSeqStack.get(0).value);
    Assert.assertEquals(2, nodeSeqStack.get(1).value);
    Assert.assertEquals(6, nodeSeqStack.get(2).value);
    Assert.assertEquals(3, nodeSeqStack.get(3).value);
    Assert.assertEquals(7, nodeSeqStack.get(4).value);
    Assert.assertEquals(4, nodeSeqStack.get(5).value);
    Assert.assertEquals(5, nodeSeqStack.get(6).value);

    Assert.assertEquals(7, edgeStack.size());

    Assert.assertEquals("1-2", edgeStack.get(0));
    Assert.assertEquals("2-5", edgeStack.get(1));
    Assert.assertEquals("2-3", edgeStack.get(2));
    Assert.assertEquals("2-6", edgeStack.get(3));
    Assert.assertEquals("3-4", edgeStack.get(4));
    Assert.assertEquals("3-7", edgeStack.get(5));
    Assert.assertEquals("4-5", edgeStack.get(6));
  }

  void init(GraphGNode g)
  {
    // init all the nods to UNVISITED
    for(GNode n: g.nodes) {
      n.status = GNode.Status.UNDISCOVERED;
    }
  }

  int time=0;

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
    searchRecursive(g,g.nodes.get(0));

    Assert.assertEquals(7, nodeSeqRecursive.size());

    Assert.assertEquals(1, nodeSeqRecursive.get(0).value);
    Assert.assertEquals(2, nodeSeqRecursive.get(1).value);
    Assert.assertEquals(5, nodeSeqRecursive.get(2).value);
    Assert.assertEquals(4, nodeSeqRecursive.get(3).value);
    Assert.assertEquals(3, nodeSeqRecursive.get(4).value);
    Assert.assertEquals(7, nodeSeqRecursive.get(5).value);
    Assert.assertEquals(6, nodeSeqRecursive.get(6).value);

    Assert.assertEquals(7, edgeRecursive.size());
    Assert.assertEquals("1-2", edgeRecursive.get(0));
    Assert.assertEquals("2-5", edgeRecursive.get(1));
    Assert.assertEquals("5-4", edgeRecursive.get(2));
    Assert.assertEquals("4-3", edgeRecursive.get(3));
    Assert.assertEquals("3-2", edgeRecursive.get(4));
    Assert.assertEquals("3-7", edgeRecursive.get(5));
    Assert.assertEquals("2-6", edgeRecursive.get(6));
  }

  void searchRecursive(GraphGNode g, GNode actual)
  {
    actual.status= GNode.Status.DISCOVERED;
    time++;
    actual.entryTime=time;

    if(actual.status== GNode.Status.DISCOVERED)
    {
      process(nodeSeqRecursive,actual);
    }

    for(GNode n: actual.adj)
    {
      if(n.status== GNode.Status.UNDISCOVERED)
      {
        n.parent = actual;
        processEdge(edgeRecursive,actual,n);
        searchRecursive(g, n);
      }
      else if((n.status== GNode.Status.DISCOVERED && actual.parent!=n)|| g.isDirected)
        processEdge(edgeRecursive,actual,n);
    }
    time++;
    actual.exitTime=time;
    actual.status= GNode.Status.PROCESSED;
  }

  void searchStack(GraphGNode g, GNode head)
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
      GNode actual = stack.pop();
      // process if it is not already visited
      if(actual.status== GNode.Status.DISCOVERED)
      {
        process(nodeSeqStack,actual);
        actual.status= GNode.Status.PROCESSED;
      }
      // loop through all the other one
      for(GNode n: actual.adj)
      {
        if(n.status!= GNode.Status.PROCESSED || g.isDirected)
        {
          processEdge(edgeStack,actual, n);
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

  private void process(List<GNode> nodeSeq,GNode actual)
  {
    System.out.println(actual.value);
    nodeSeq.add(actual);
  }

  private void processEdge(List<String> edgeSeq, GNode node1, GNode node2)
  {
    System.out.println("edge: "+node1+" - "+node2);
    edgeSeq.add(node1.value+"-"+node2.value);
  }

}
