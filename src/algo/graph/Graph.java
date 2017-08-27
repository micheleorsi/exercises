package algo.graph;


import java.util.Arrays;
import java.util.List;

public class Graph<T extends GNode>
{
  protected List<T> nodes;
  boolean isDirected;

  void init()
  {
    for(T n: nodes)
    {
      n.status= GNode.Status.UNDISCOVERED;
    }
  }

  public static class Builder
  {
    /**
     *      B --------> D
     *      ^ \         ^
     *      |  v        |
     *      A -> C ---> E
     *      ^      \    ^
     *      |       v  /
     *      G -----> F
     */
    static Graph buildDAGWith1TopologicalSort() {
      GNode a = new GNode("a");
      GNode b = new GNode("b");
      GNode c = new GNode("c");
      GNode d = new GNode("d");
      GNode e = new GNode("e");
      GNode f = new GNode("f");
      GNode g = new GNode("g");

      a.adj = Arrays.asList(b,c);
      b.adj = Arrays.asList(c,d);
      c.adj = Arrays.asList(e,f);
      d.adj = Arrays.asList();
      e.adj = Arrays.asList(d);
      f.adj = Arrays.asList(e);
      g.adj = Arrays.asList(a,f);

      Graph graph = new Graph();
      graph.isDirected=true;
      graph.nodes = Arrays.asList(a,b,c,d,e,f,g);
      return graph;
    }

    static Graph buildDAGWithCycle() {
      GNode a = new GNode("a");
      GNode b = new GNode("b");
      GNode c = new GNode("c");
      GNode d = new GNode("d");
      GNode e = new GNode("e");
      GNode f = new GNode("f");
      GNode g = new GNode("g");

      a.adj = Arrays.asList(b,c);
      b.adj = Arrays.asList(c,d);
      c.adj = Arrays.asList(e,f);
      d.adj = Arrays.asList();
      e.adj = Arrays.asList(d,f);
      f.adj = Arrays.asList(e);
      g.adj = Arrays.asList(a,f);

      Graph graph = new Graph();
      graph.isDirected=true;
      graph.nodes = Arrays.asList(g,a,b,c,d,e,f);
      return graph;
    }
    /**
     *                  1
     *                  |
     *            |-5 - 2 - 6
     *            |     |
     *            |     3
     *            |    / \
     *            |---4  7
     */
    static Graph<GNode> buildWithCycle()
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
      three.adj = Arrays.asList(two,four,seven);
      four.adj = Arrays.asList(three,five);
      five.adj = Arrays.asList(two,four);
      six.adj = Arrays.asList(two);
      seven.adj = Arrays.asList(three);

      Graph<GNode> g = new Graph();
      g.nodes = Arrays.asList(one,two,three,four,five,six,seven);
      return g;
    }

    /**
     *                  1
     *                  |
     *             -5 - 2 - 6
     *                  |
     *                  3
     *                 / \
     *                4  7
     */
    static Graph buildWithoutCycle()
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
      three.adj = Arrays.asList(two,four,seven);
      four.adj = Arrays.asList(three);
      five.adj = Arrays.asList(two);
      six.adj = Arrays.asList(two);
      seven.adj = Arrays.asList(three);

      Graph g = new Graph();
      g.nodes = Arrays.asList(one,two,three,four,five,six,seven);
      return g;
    }

    /**
     *        1
     *       / \
     *      2  3 - 5
     *      \ /
     *       4
     *
     *  8 - 7- 6
     *
     *  9 - 10 - 11 - 12
     *  \             |
     *  \-------------/
     *
     * @return
     */
    static Graph buildConnectedComponent()
    {
      GNode one = new GNode(1);
      GNode two = new GNode(2);
      GNode three = new GNode(3);
      GNode four = new GNode(4);
      GNode five = new GNode(5);
      GNode six = new GNode(6);
      GNode seven = new GNode(7);
      GNode eigth = new GNode(8);
      GNode nine = new GNode(9);
      GNode ten = new GNode(10);
      GNode eleven = new GNode(11);
      GNode twelve = new GNode(12);

      one.adj = Arrays.asList(two,three);
      two.adj = Arrays.asList(one,four);
      three.adj = Arrays.asList(four,one,five);
      four.adj = Arrays.asList(two,three);
      five.adj = Arrays.asList(three);

      six.adj = Arrays.asList(seven);
      seven.adj = Arrays.asList(six,eigth);
      eigth.adj = Arrays.asList(seven);

      nine.adj = Arrays.asList(ten,twelve);
      ten.adj = Arrays.asList(nine,eleven);
      eleven.adj = Arrays.asList(ten,twelve);
      twelve.adj = Arrays.asList(eleven,nine);

      Graph g = new Graph();
      g.nodes = Arrays.asList(one,two,three,four,five,six,seven,eigth,nine,ten,eleven,twelve);
      return g;
    }

    /**
     *        1
     *       / \
     *      2 - 3 - 5
     *      \  /
     *       4
     *
     *
     * @return
     */
    static Graph<TCNode> buildTwoVertexColourNotBiPartite() {
      TCNode one = new TCNode(1);
      TCNode two = new TCNode(2);
      TCNode three = new TCNode(3);
      TCNode four = new TCNode(4);
      TCNode five = new TCNode(5);

      one.adj = Arrays.asList(two,three);
      two.adj = Arrays.asList(one,three,four);
      three.adj = Arrays.asList(one,two,four);
      four.adj = Arrays.asList(two,three);
      five.adj = Arrays.asList(three);

      Graph<TCNode> g = new Graph();
      g.nodes = Arrays.asList(one,two,three,four,five);
      return g;
    }

    /**
     *        1
     *       / \
     *      2  3 - 5
     *      \ /
     *       4
     *
     *  8 - 7 - 6
     *
     *  9 - 10 - 11 - 12
     *  \             |
     *  \-------------/
     *
     * @return
     */
    static Graph<TCNode> buildTwoVertexColourBiPartite()
    {
      TCNode one = new TCNode(1);
      TCNode two = new TCNode(2);
      TCNode three = new TCNode(3);
      TCNode four = new TCNode(4);
      TCNode five = new TCNode(5);
      TCNode six = new TCNode(6);
      TCNode seven = new TCNode(7);
      TCNode eigth = new TCNode(8);
      TCNode nine = new TCNode(9);
      TCNode ten = new TCNode(10);
      TCNode eleven = new TCNode(11);
      TCNode twelve = new TCNode(12);

      one.adj = Arrays.asList(two,three);
      two.adj = Arrays.asList(one,four);
      three.adj = Arrays.asList(four,one,five);
      four.adj = Arrays.asList(two,three);
      five.adj = Arrays.asList(three);

      six.adj = Arrays.asList(seven);
      seven.adj = Arrays.asList(six,eigth);
      eigth.adj = Arrays.asList(seven);

      nine.adj = Arrays.asList(ten,twelve);
      ten.adj = Arrays.asList(nine,eleven);
      eleven.adj = Arrays.asList(ten,twelve);
      twelve.adj = Arrays.asList(eleven,nine);

      Graph<TCNode> g = new Graph();
      g.nodes = Arrays.asList(one,two,three,four,five,six,seven,eigth,nine,ten,eleven,twelve);
      return g;
    }
  }
}
