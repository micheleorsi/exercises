package algo.graph;

import java.util.List;

public abstract class AbstractGS implements GraphSearch {

  @Override
  public <T> void processEarly(List<GNode> nodeSeq, GNode<T> actual)
  {
    System.out.println("early: "+actual.value);
    nodeSeq.add(actual);
  }

  @Override
  public <T> void processLate(List<GNode> nodeSeq, GNode<T> actual) {
    System.out.println("late: "+actual.value);
  }

  @Override
  public <T> void processEdge(List<String> edgeSeq, GNode<T> node1, GNode<T> node2)
  {
    System.out.println("edge: "+node1+" - "+node2);
    edgeSeq.add(node1.value+"-"+node2.value);
  }

}
