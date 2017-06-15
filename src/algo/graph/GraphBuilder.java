package algo.graph;

import java.util.Arrays;

public class GraphBuilder
{
  static Graph build()
  {
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    Node six = new Node(6);
    Node seven = new Node(7);
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
