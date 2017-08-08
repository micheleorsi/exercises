package algo.graph;

import java.util.Arrays;

public class GraphBuilder
{
  static Graph build()
  {
    GNode one = new GNode(1);
    GNode two = new GNode(2);
    GNode three = new GNode(3);
    GNode four = new GNode(4);
    GNode five = new GNode(5);
    GNode six = new GNode(6);
    GNode seven = new GNode(7);
    one.adj = Arrays.asList(two);
    two.adj = Arrays.asList(five,three,six);
    three.adj = Arrays.asList(four,seven);
    four.adj = Arrays.asList(five);
    five.adj = Arrays.asList();
    six.adj = Arrays.asList();
    seven.adj = Arrays.asList();

    Graph g = new Graph();
    g.nodes = Arrays.asList(one,two,three,four,five,six,seven);
    return g;
  }
}
