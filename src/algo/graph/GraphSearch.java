package algo.graph;

import java.util.List;

public interface GraphSearch {

    void search(GraphGNode g, GNode actual);

    void processEarly(List<GNode> nodeSeq, GNode actual);

    void processLate(List<GNode> nodeSeq, GNode actual);

    void processEdge(List<String> edgeSeq, GNode node1, GNode node2);

}
