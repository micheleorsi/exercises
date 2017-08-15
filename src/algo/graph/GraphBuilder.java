package algo.graph;

import java.util.Arrays;

public class GraphBuilder
{
  /**
   *                  1
   *                  |
   *            |-5 - 2 - 6
   *            |     |
   *            |     3
   *            |    / \
   *            |---4  7
   */
  static GraphGNode build()
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
