package algo.graph;


public interface GraphSearch {

    <T> void search(Graph g, GNode<T> actual);

    <T> void processEarly(GNode<T> actual);

    <T> void processLate(GNode<T> actual);

    <T> void processEdge(GNode<T> node1, GNode<T> node2);

}
