package algo.graph;

import java.util.List;

public abstract class AbstractGS implements GraphSearch {

  public void process(List<GNode> nodeSeq, GNode actual)
  {
    System.out.println(actual.value);
    nodeSeq.add(actual);
  }

  public void processEdge(List<String> edgeSeq, GNode node1, GNode node2)
  {
    System.out.println("edge: "+node1+" - "+node2);
    edgeSeq.add(node1.value+"-"+node2.value);
  }

}
