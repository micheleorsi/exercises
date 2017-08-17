package algo.graph;

import java.util.List;

public abstract class AbstractGS implements GraphSearch {

  @Override
  public void processEarly(List<GNode> nodeSeq, GNode actual)
  {
    System.out.println("early: "+actual.value);
    nodeSeq.add(actual);
  }

  @Override
  public void processLate(List<GNode> nodeSeq, GNode actual) {
    System.out.println("late: "+actual.value);
  }

  @Override
  public void processEdge(List<String> edgeSeq, GNode node1, GNode node2)
  {
    System.out.println("edge: "+node1+" - "+node2);
    edgeSeq.add(node1.value+"-"+node2.value);
  }

}
