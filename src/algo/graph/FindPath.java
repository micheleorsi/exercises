package algo.graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 *                  1
 *                  |
 *            |-5 - 2 - 6
 *            |     |
 *            |     3
 *            |    / \
 *            |---4  7
 */
public class FindPath
{
    List<GNode> list = new LinkedList<>();

    FP algo;
    FPBidirectional algobid;
    List<GNode> nodeSeq = new LinkedList<>();
    List<String> edgeSeq = new LinkedList<>();

    @Before
    public void setup() {
        algo = new FP(nodeSeq,edgeSeq);
        algobid = new FPBidirectional(nodeSeq,edgeSeq);
    }

    @Test
    public void testFindPath()
    {
        Graph<GNode> g = Graph.Builder.buildWithCycle();
        g.init();

        Stack<GNode> list = algo.findPath(g,g.nodes.get(0),g.nodes.get(6));

        Assert.assertEquals(1, nodeSeq.get(0).value);
        Assert.assertEquals(2, nodeSeq.get(1).value);
        Assert.assertEquals(5, nodeSeq.get(2).value);
        Assert.assertEquals(3, nodeSeq.get(3).value);
        Assert.assertEquals(6, nodeSeq.get(4).value);
        Assert.assertEquals(4, nodeSeq.get(5).value);
        Assert.assertEquals(7, nodeSeq.get(6).value);

        Assert.assertEquals(7, edgeSeq.size());

        Assert.assertEquals("1-2", edgeSeq.get(0));
        Assert.assertEquals("2-5", edgeSeq.get(1));
        Assert.assertEquals("2-3", edgeSeq.get(2));
        Assert.assertEquals("2-6", edgeSeq.get(3));
        Assert.assertEquals("5-4", edgeSeq.get(4));
        Assert.assertEquals("3-4", edgeSeq.get(5));
        Assert.assertEquals("3-7", edgeSeq.get(6));

        int[] expectedOrder = new int[] {1,2,3,7};
        for(int i=0; i<list.size(); i++) {
            Assert.assertEquals(expectedOrder[i],list.pop().value);
        }
    }

    @Test
    public void testbidirectional() {
        Graph<GNode> g = Graph.Builder.buildWithCycle();
        g.init();

        boolean val = algobid.findPathBidirectional(g,g.nodes.get(0),g.nodes.get(6));
        Assert.assertTrue(val);

        List<GNode> temp = new ArrayList<>(g.nodes);
        GNode node = new GNode(10);
        node.adj = Arrays.asList();
        temp.add(node);
        g.nodes = temp;

        g.init();

        val = algobid.findPathBidirectional(g,g.nodes.get(0),g.nodes.get(7));
        Assert.assertFalse(val);
    }

    class FPBidirectional extends FP {

        public FPBidirectional(List<GNode> nodeSeq, List<String> edgeSeq) {
            super(nodeSeq, edgeSeq);
        }

        <T> boolean findPathBidirectional(Graph g, GNode<T> head, GNode<T> last) {
            // BFS on both nodes at the same time
            Queue<GNode<T>> queueA = new LinkedList<>();
            Queue<GNode<T>> queueB = new LinkedList<>();
            Set<GNode<T>> visitedA = new HashSet<>();
            Set<GNode<T>> visitedB = new HashSet<>();

            visitedA.add(head);
            visitedB.add(last);
            queueA.add(head);
            queueB.add(last);

            while (!queueA.isEmpty() && !queueB.isEmpty()) {
                if (pathExists(queueA, visitedA, visitedB)) {
                    return true;
                }
                if (pathExists(queueB, visitedB, visitedA)) {
                    return true;
                }
            }

            return false;

        }

        <T> boolean pathExists(Queue<GNode<T>> queue, Set<GNode<T>> visitedFromThisSide, Set<GNode<T>> visitedFromThatSide) {
            if (!queue.isEmpty()) {
                GNode<T> next = queue.remove();
                for (GNode<T> adjacent : next.adj) {
                    if (visitedFromThatSide.contains(adjacent)) {
                        return true;
                    } else if (visitedFromThisSide.add(adjacent)) {
                        queue.add(adjacent);
                    }
                }
            }
            return false;
        }
    }

    class FP extends BFS {

        public FP(List<GNode> nodeSeq, List<String> edgeSeq) {
            super(nodeSeq,edgeSeq);
        }

        <T> Stack<GNode> findPath(Graph g, GNode<T> head, GNode<T> last) {
            this.search(g,head); // skip when hit last
            Stack<GNode> path = new Stack<>();
            while (last != null) {
                path.push(last);
                last = last.parent;
            }
            return path;
        }
    }

}
