package algo.graph;

import java.util.List;

public interface GraphSearch {

    void search(GraphGNode g, GNode actual);

    void process(List<GNode> nodeSeq, GNode actual);

    void processEdge(List<String> edgeSeq, GNode node1, GNode node2);

}
