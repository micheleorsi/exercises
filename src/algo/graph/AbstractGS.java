package algo.graph;

import java.util.List;

public abstract class AbstractGS implements GraphSearch {

  protected List<GNode> nodeSeq;
  protected List<String> edgeSeq;

  public AbstractGS(List<GNode> nodeSeq, List<String> edgeSeq) {
    this.nodeSeq = nodeSeq;
    this.edgeSeq = edgeSeq;
  }

  @Override
  public <T> void processEarly(GNode<T> actual)
  {
    System.out.println("early: "+actual.value);
    nodeSeq.add(actual);
  }

  @Override
  public <T> void processLate(GNode<T> actual) {
    System.out.println("late: "+actual.value);
  }

  @Override
  public <T> void processEdge(GNode<T> node1, GNode<T> node2)
  {
    System.out.println("edge: "+node1+" - "+node2);
    edgeSeq.add(node1.value+"-"+node2.value);
  }

}
