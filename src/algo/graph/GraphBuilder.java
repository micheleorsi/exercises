package algo.graph;

import java.util.Arrays;

public class GraphBuilder
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
  static GraphGNode buildDAGWith1TopologicalSort() {
    GNode a = new GNode(1);
    GNode b = new GNode(2);
    GNode c = new GNode(3);
    GNode d = new GNode(4);
    GNode e = new GNode(5);
    GNode f = new GNode(6);
    GNode g = new GNode(7);

    a.adj = Arrays.asList(b,c);
    b.adj = Arrays.asList(c,d);
    c.adj = Arrays.asList(e,f);
    d.adj = Arrays.asList();
    e.adj = Arrays.asList(d);
    f.adj = Arrays.asList(e);
    g.adj = Arrays.asList(a,f);

    GraphGNode graph = new GraphGNode();
    graph.isDirected=true;
    graph.nodes = Arrays.asList(a,b,c,d,e,f,g);
    return graph;
  }

  static GraphGNode buildDAGWithCycle() {
    GNode a = new GNode(1);
    GNode b = new GNode(2);
    GNode c = new GNode(3);
    GNode d = new GNode(4);
    GNode e = new GNode(5);
    GNode f = new GNode(6);
    GNode g = new GNode(7);

    a.adj = Arrays.asList(b,c);
    b.adj = Arrays.asList(c,d);
    c.adj = Arrays.asList(e,f);
    d.adj = Arrays.asList();
    e.adj = Arrays.asList(d,f);
    f.adj = Arrays.asList(e);
    g.adj = Arrays.asList(a,f);

    GraphGNode graph = new GraphGNode();
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
  static GraphGNode buildWithCycle()
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

    GraphGNode g = new GraphGNode();
    g.nodes = Arrays.asList(one,two,three,four,five,six,seven);
    return g;
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
  static GraphGNode buildWithoutCycle()
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

    GraphGNode g = new GraphGNode();
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
  static GraphGNode buildConnectedComponent()
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

    GraphGNode g = new GraphGNode();
    g.nodes = Arrays.asList(one,two,three,four,five,six,seven,eigth,nine,ten,eleven,twelve);
    return g;
  }
}
