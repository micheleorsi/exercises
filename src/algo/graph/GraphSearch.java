package algo.graph;

import java.util.List;

public interface GraphSearch {

    <T> void search(Graph g, GNode<T> actual);

    <T> void processEarly(List<GNode> nodeSeq, GNode<T> actual);

    <T> void processLate(List<GNode> nodeSeq, GNode<T> actual);

    <T> void processEdge(List<String> edgeSeq, GNode<T> node1, GNode<T> node2);

}
